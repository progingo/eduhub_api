package org.progingo.service;

import org.progingo.application.FileApp;
import org.progingo.application.UserApp;
import org.progingo.controller.request.user.UserLoginRequest;
import org.progingo.controller.request.user.UserSignRequest;
import org.progingo.controller.request.user.UserUpdateBaseInfoRequest;
import org.progingo.controller.vo.ProjectVO;
import org.progingo.controller.vo.UserInfoVO;
import org.progingo.domain.FileUploadRecord;
import org.progingo.domain.project.ProjectBO;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.domain.user.*;
import org.progingo.infrastructure.project.ProjectAdapter;
import org.progingo.infrastructure.repository.UserAdapter;
import org.progingo.infrastructure.user.UserHelper;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserHelper userHelper;
    @Autowired
    private UserApp userApp;
    @Autowired
    private UserAdapter userAdapter;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectAdapter projectAdapter;
    @Autowired
    private FileApp fileApp;

    public JsonResult signUser(UserSignRequest userSignRequest) {
        User signUser = User.builder()
                .nickname(userSignRequest.getNickname())
                .password(userSignRequest.getPassword())
                .phone(userSignRequest.getPhone())
                .email(userSignRequest.getEmail())
                .build();

        ActionResult checkResult = userHelper.checkSignUser(signUser);
        if(!checkResult.isSuccess()){
            return JsonResult.fail(checkResult.getMsg());
        }

        ActionResult signResult = userApp.signUser(signUser);
        if(!signResult.isSuccess()){
           return JsonResult.fail(signResult.getMsg());
       }
        return JsonResult.ok();
    }

    public JsonResult login(UserLoginRequest userLoginRequest) {
        User loginUser = User.builder().phone(userLoginRequest.getPhone()).password(userLoginRequest.getPassword()).build();

        if (!userHelper.checkLoginUser(loginUser).isSuccess()){
            return JsonResult.fail("手机号或密码不正确");
        }

        ActionResult loginResult = userApp.login(loginUser);

        if (!loginResult.isSuccess()){
            return JsonResult.fail("手机号或密码不正确");
        }

        return JsonResult.ok(loginResult.getMsg());

    }

    public JsonResult getUserInfo(UserBO user) {
        UserInfoVO userVO = userAdapter.toVO(user);
        if (userVO == null || userVO.getUsername().isEmpty()){
            return JsonResult.fail(401,"请重新登陆");
        }
        return JsonResult.ok(userVO);
    }

    public JsonResult getUserInfoByUsername(UserBO user,String username) {
        if (user == null){
            return JsonResult.fail(401,"请重新登陆");
        }
        UserBO userBO = userApp.getUserInfoByUsername(username);
        if (userBO == null){
            return JsonResult.fail("用户不存在");
        }
        UserInfoVO userInfoVO = userAdapter.toVO(userBO);
        return JsonResult.ok(userInfoVO);
    }


    public JsonResult updateUserBaseInfo(UserBO user, UserUpdateBaseInfoRequest userUpdateBaseInfoRequest) {
        if (user == null){
            return JsonResult.fail(401,"请重新登陆");
        }
        User updateUser = User.builder()
                .nickname(userUpdateBaseInfoRequest.getNickname())
                .email(userUpdateBaseInfoRequest.getEmail())
                .build();

        if (userUpdateBaseInfoRequest.getProfilePhotoId() != null && !userUpdateBaseInfoRequest.getProfilePhotoId().isEmpty()){
            FileUploadRecord file = fileApp.findFileById(user, Long.parseLong(userUpdateBaseInfoRequest.getProfilePhotoId()));
            updateUser.setProfilePhoto(file.getUrl());
        }

        updateUser.setId(user.getId());

        ActionResult actionResult = userHelper.checkUpdateBaseInfoUser(updateUser);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }

        actionResult = userApp.updateUser(updateUser);
        if (!actionResult.isSuccess()){
            return JsonResult.fail(actionResult.getMsg());
        }

        return JsonResult.ok();

    }

    /**
     * ①自己查看自己创建的项目。自己就是user.username，这时username为mine或者user.username == username
     * ②别人查看自己创建的项目。user.username != username 或者 user.username == ""
     * @param user 访问者
     * @param username 被访问者
     * @return
     */
    public JsonResult getCreateProject(UserBO user, String username) {

        List<ProjectBO> projectBOList = "mine".equals(username) || username.equals(user.getUsername())
                ? projectRepository.findProjectByPossessorUsername(user.getUsername())
                : projectRepository.findPublicProjectsByPossessorUsername(username);
        // 转换为 ProjectVO 列表
        List<ProjectVO> projectVOList = projectBOList.stream()
                .map(projectAdapter::toVO) // 转换为 VO
                .collect(Collectors.toList());
        return JsonResult.ok(projectVOList);
    }

    public JsonResult getJoinProject(UserBO user) {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }
        List<ProjectBO> projectList = projectRepository.findProjectByMemberUsername(user.getUsername());
        List<ProjectVO> projectVOList = projectList.stream()
                .map(x -> projectAdapter.toVO(x))
                .collect(Collectors.toList());
        return JsonResult.ok(projectVOList);
    }

    public JsonResult getUserInfoByNickName(String nickName) {
        List<UserBO> userList = userApp.getUserInfoByNickName(nickName);
        List<UserInfoVO> userVOList = userList
                .stream()
                .map(x -> userAdapter.toVO(x))
                .collect(Collectors.toList());
        return JsonResult.ok(userVOList);
    }
}
