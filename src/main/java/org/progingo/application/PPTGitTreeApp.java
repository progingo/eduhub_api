package org.progingo.application;

import org.progingo.controller.vo.pptTree.edges.Edges;
import org.progingo.controller.vo.pptTree.nodes.Node;
import org.progingo.controller.vo.pptTree.nodes.NodeData;
import org.progingo.controller.vo.pptTree.nodes.Position;
import org.progingo.dao.PptGitTreeDao;
import org.progingo.dao.PptInfoDao;
import org.progingo.domain.PptGitTree;
import org.progingo.domain.PptGitTreeExample;
import org.progingo.domain.ppt.*;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PPTGitTreeApp {

    @Autowired
    private MyUtil myUtil;
    @Autowired
    private PPTGitTreeRepository pptGitTreeRepository;
    @Autowired
    private PptInfoDao pptInfoDao;
    @Autowired
    private PptGitTreeDao pptGitTreeDao;

    public ActionResult init(String username, String resourceKey, String pptKey) {

        String key = myUtil.nextId("ppt_git_tree_key");//我们的工具类中的这个方法正好能满足这个key所需要的条件，所以我们直接调用
        PptGitTreeBO pptGitTreeBO = PptGitTreeBO.builder()
                .remark("资源初始化创建")
                .key(key)
                .username(username)
                .resourceKey(resourceKey)
                .pptKey(pptKey)
                .isRoot(true)
                .operation(PPTTreeOperation.CREAET)
                .parentKey("")
                .mergeParentKey(null)
                .isDelete(false)
                .build();

        boolean succ = pptGitTreeRepository.addTreeNode(pptGitTreeBO);
        if (!succ){
            return ActionResult.fail("创建节点失败");
        }
        return ActionResult.ok(key);

    }

    /*
    这个pptKey要给旧的节点的key
     */
    public ActionResult createNode(String username,String oldPPTKey, String pptKey, String remark) {
        PptInfoExample pptInfoExample = new PptInfoExample();
        pptInfoExample.createCriteria().andKeyEqualTo(oldPPTKey);
        PptInfo pptInfo = pptInfoDao.selectByExample(pptInfoExample).stream().findFirst().orElse(null);
        if (pptInfo == null){
            return ActionResult.fail(ResultCode.PPT_NOT_EXIST);
        }

        String resourceKey = pptGitTreeRepository.findResourceKeyByNodeKey(pptInfo.getNodeKey());

        String nodeKey = pptInfo.getNodeKey();
        String key = myUtil.nextId("ppt_git_tree_key");//我们的工具类中的这个方法正好能满足这个key所需要的条件，所以我们直接调用
        PptGitTreeBO pptGitTreeBO = PptGitTreeBO.builder()
                .remark("资源初始化创建")
                .key(key)
                .username(username)
                .resourceKey(resourceKey)
                .pptKey(pptKey)
                .remark(remark)
                .isRoot(false)
                .operation(PPTTreeOperation.COMMIT)
                .parentKey(nodeKey)
                .mergeParentKey(null)
                .isDelete(false)
                .build();
        boolean b = pptGitTreeRepository.addTreeNode(pptGitTreeBO);

        if (!b){
            return ActionResult.fail("提交失败");
        }
        return ActionResult.ok(key);
    }


    public ActionResult createNode(String username,String nodeKey1,String nodeKey2, String pptKey, String remark) {
        PptGitTreeBO pptGitTreeBOByNodeKey = pptGitTreeRepository.findByKey(nodeKey1);


        String key = myUtil.nextId("ppt_git_tree_key");//我们的工具类中的这个方法正好能满足这个key所需要的条件，所以我们直接调用
        PptGitTreeBO pptGitTreeBO = PptGitTreeBO.builder()
                .remark("资源初始化创建")
                .key(key)
                .username(username)
                .resourceKey(pptGitTreeBOByNodeKey.getResourceKey())
                .pptKey(pptKey)
                .remark(remark)
                .isRoot(false)
                .operation(PPTTreeOperation.MERGE)
                .parentKey(nodeKey1)
                .mergeParentKey(nodeKey2)
                .isDelete(false)
                .build();
        boolean b = pptGitTreeRepository.addTreeNode(pptGitTreeBO);

        if (!b){
            return ActionResult.fail("提交失败");
        }
        return ActionResult.ok(key);
    }

    public Object[] getTree(String resourceKey) {
        PptGitTreeExample pptGitTreeExample = new PptGitTreeExample();
        pptGitTreeExample.createCriteria()
                .andResourceKeyEqualTo(resourceKey)
                .andIsRootEqualTo(true)
                .andIsDeleteEqualTo(false);
        PptGitTree pptGitTree = pptGitTreeDao.selectByExample(pptGitTreeExample).stream().findFirst().orElse(null);
        if (pptGitTree == null){
            return null;
        }
        String rootKey = pptGitTree.getKey();
        //拿到根节点后开始遍历整个树，采取广度优先
        LinkedList<PptGitTreeBO> nodeList = new LinkedList<>();
        //根节点
        PptGitTreeBO node = pptGitTreeRepository.findByKey(rootKey);
        nodeList.add(node);
        //初始化信息
        int level = 1;//层数
        int levelNodeNum = 1;//当前层数节点数量
        int nextLevelNodeNum = 0;//下一层节点数量
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        //前端需要的数据类型
        List<Node> nodesVOList = new LinkedList<>();
        List<Edges> edgesVOList = new LinkedList<>();

        while (!nodeList.isEmpty()){
            //拿到当前层节点
            for(int i = 0;i < levelNodeNum;++i){
                PptGitTreeBO pptGitTreeBO = nodeList.removeFirst();
                //处理当前节点
                //节点信息
                Node nodeVO = Node.builder()
                        .id(pptGitTreeBO.getKey())
                        .data(new NodeData(
                                pptGitTreeBO.getRemark(), dateFormat.format(pptGitTreeBO.getGmtUpdate())
                                )
                        )
                        .type("special")
                        .label(pptGitTreeBO.getRemark())
                        .position(new Position(i * 290, level * 180))
                        .build();
                nodesVOList.add(nodeVO);
                //关系信息
                if (!pptGitTreeBO.getIsRoot()){
                    Edges edgesVO = Edges.builder()
                            .id("e" + pptGitTreeBO.getParentKey() + "-" + pptGitTreeBO.getKey())
                            .source(pptGitTreeBO.getParentKey())
                            .target(pptGitTreeBO.getKey())
                            .animated(true)
                            .build();
                    edgesVOList.add(edgesVO);
                }

                //获取当前节点子节点和数量
                List<PptGitTreeBO> childrenNodeList = pptGitTreeRepository
                        .childrenNode(pptGitTreeBO.getKey());//子节点数量
                nodeList.addAll(childrenNodeList);//添加至节点列表
                nextLevelNodeNum += childrenNodeList.size();
                //收集节点的前端数据结构
            }
            levelNodeNum = nextLevelNodeNum;
            nextLevelNodeNum = 0;
            ++level;
        }

        Object[] datas = new Object[2];
        datas[0] = nodesVOList;
        datas[1] = edgesVOList;

        return datas;

    }


    /**
     * 检查两个节点是否有血缘关系(节点是另一个节点的直系子孙)
     * @param key1
     * @param key2
     */
    public boolean checkConsanguinity(String key1, String key2) {
        PptGitTreeBO pptGitTreeBO;
        String key = key1;
        //key1是key2的直系子孙
        do {
            if (key.equals(key2)){
                return true;
            }
            pptGitTreeBO = pptGitTreeRepository.findByKey(key);
            key = pptGitTreeBO.getParentKey();

        }while (!pptGitTreeBO.getIsRoot());

        key = key2;
        do {
            if (key.equals(key1)){
                return true;
            }
            pptGitTreeBO = pptGitTreeRepository.findByKey(key);
            key = pptGitTreeBO.getParentKey();
        }while (!pptGitTreeBO.getIsRoot());

        return false;

    }


    /**
     * resourceKey获取节点
     */
    public List<PptGitTree> getNodeInfoByResourceKey(String resourceKey) {
        PptGitTreeExample pptGitTreeExample = new PptGitTreeExample();
        pptGitTreeExample.createCriteria()
                .andResourceKeyEqualTo(resourceKey)
                .andIsDeleteEqualTo(false);
        return pptGitTreeDao.selectByExample(pptGitTreeExample);
    }

    /**
     * 批量获取节点的信息
     */
    public Map<String, PptGitTreeBO> batchGetNodeInfo(Set<String> pptList) {
        Map<String, PptGitTreeBO> map = new HashMap<>();
        pptList.forEach(key -> {
            PptGitTreeBO pptGitTreeBO = pptGitTreeRepository.findByKey(key);
            map.put(key, pptGitTreeBO);
        });
        return map;
    }
}
