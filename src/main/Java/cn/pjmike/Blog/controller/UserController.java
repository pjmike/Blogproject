package cn.pjmike.Blog.controller;

import cn.pjmike.Blog.domain.User;
import cn.pjmike.Blog.service.UserService;
import cn.pjmike.Blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author pjmike
 * @create 2018-02-07 15:26
 **/
@RestController
@Api(value = "UserController",description = "用户相关API")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    @ApiOperation(value = "用户主页",notes = "用户主页信息",response = ResponseResult.class)
    public ResponseResult<User> getUserInformation(@PathVariable("id") Long id) {
        ResponseResult<User> result = new ResponseResult<User>();
        User user = userService.findUserById(id);
        //判断用户是否存在
        if (user == null) {
            result.setStatus(1);
            result.setMsg("用户不存在");
        } else {
            result.setStatus(0);
            result.setMsg("获取用户信息");
        }
        result.setData(user);
        return result;
    }
    /**
     * 上传用户头像
     * 在一些小的项目，对图片存储要求不高的情况下，可以直接将图片放在一台服务器上
     * 如果对图片要求高的的场景，可以考虑使用图片服务器，例如与七牛云结合使用
     *
     * @param id
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/users/{id}/icon", consumes = "multipart/form-data")
    @ApiOperation(value = "上传用户头像",notes = "上传用户头像",response = ResponseResult.class,httpMethod = "POST",produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult<Object> uploadIcon(@PathVariable("id") Long id, @RequestParam("picture") MultipartFile file, HttpServletRequest request) throws IOException {
        ResponseResult<Object> result = new ResponseResult<Object>();
        //获取项目的webroot
        String pathroot = request.getSession().getServletContext().getRealPath("");
        //预定义图片存储路径
        String path = "";
        //获取图片原始名
        String originalfilename = file.getOriginalFilename();
        if (file.isEmpty()) {
            //图片为空
            result.setStatus(1);
            result.setMsg("上传的图片为空，上传失败");
            return result;
        }
        //新的图片名称
        String newFilename = UUID.randomUUID() + originalfilename.substring(originalfilename.lastIndexOf("."));
        path = "/img" + newFilename;
        File picfile = new File(pathroot + path);
        if (!picfile.exists()) {
            picfile.mkdirs();
        }
        //将文件写入
        file.transferTo(picfile);
        //将图片的地址写入数据库中
        User user = userService.upLoadUserIcon(id,pathroot+path);
        result.setStatus(0);
        result.setMsg("成功上传图片");
        result.setData(user);
        return result;
    }
}
