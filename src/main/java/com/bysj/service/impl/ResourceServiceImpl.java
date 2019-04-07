package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.ResourceDao;
import com.bysj.dao.UserDao;
import com.bysj.entity.Post;
import com.bysj.entity.Resource;
import com.bysj.entity.vo.query.ResourceQuery;
import com.bysj.entity.vo.request.ResourceRequest;
import com.bysj.entity.vo.response.ResourceResponse;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IPostService;
import com.bysj.service.IResourceService;
import com.bysj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 上传的资源表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements IResourceService {
    private static final String fileUrl = "D:\\user_file";

    @javax.annotation.Resource
    private ResourceDao resourceDao;

    @Autowired
    private BaseConverter<ResourceRequest, Resource> requestConverter;

    @Autowired
    private BaseConverter<Resource, ResourceResponse> responseConverter;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserHandle userHandle;

    @Autowired
    private IPostService postService;

    @javax.annotation.Resource
    private UserDao userDao;

    @Override
    public Integer saveResource(ResourceRequest request) throws Exception {
        Resource resource = requestConverter.convert(request, Resource.class);
        return resourceDao.insert(resource);
    }

    @Override
    public Integer updateResource(ResourceRequest request) throws Exception {
        Resource resource = requestConverter.convert(request, Resource.class);
        return resourceDao.update(resource);
    }

    @Override
    public List<ResourceResponse> findListResource(ResourceQuery query) throws Exception {
        List<Resource> resourceList = resourceDao.findQuery(query);
        //TODO
        List<ResourceResponse> resourceResponse = responseConverter.convert(resourceList, ResourceResponse.class);
        return resourceResponse;
    }

    @Override
    public PageResult<ResourceResponse> findPageResource(ResourceQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListResource(query));
    }

    @Override
    public void downloadResource(Integer id, HttpServletResponse response) throws Exception {
        Resource resource = resourceDao.getById(id);
        UserResponse user = userHandle.getCurrentUserInfo();
        // 获取到帖子判断用户积分是否足够下载该资源
        Post post = postService.getByResourceId(id);
        // 获取到资源路径然后创建文件和文件输入流和输出流
        File file = new File(resource.getFileUrl());
        if (!file.exists()) {
            return;
        }

        FileInputStream is = new FileInputStream(file);
        ServletOutputStream os = response.getOutputStream();

        if (user.getMoney() < post.getNeedMoney()) {
            byte[] bytes = "您的积分不够！".getBytes("GBK");
            os.write(bytes);
            os.flush();
            return ;
        }
        download(resource, response,is ,os);
        userDao.updateUserMoney(user.getMoney() - post.getNeedMoney(), user.getId());

    }

    private void download(Resource resource, HttpServletResponse response,FileInputStream is, ServletOutputStream os) throws IOException {
        response.setContentType("multipart/form-data");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(resource.getFileName().getBytes("UTF-8"), "UTF-8") + "\"");
        int len;
        byte[] bytes = new byte[1024];
        try {
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception e) {
                System.out.println("关闭IO流异常!");
                e.printStackTrace();
            }
        }
    }

}
