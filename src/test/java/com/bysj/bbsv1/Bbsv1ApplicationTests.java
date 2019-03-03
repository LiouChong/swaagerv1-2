package com.bysj.bbsv1;

import com.bysj.common.utils.NumberChineseEx;
import com.bysj.dao.PostDao;
import com.bysj.dao.UserDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.service.IPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bbsv1ApplicationTests {
    @Resource
    UserDao userDao;
    @Autowired
    IPostService postService;

    @Resource
    NumberChineseEx numberChineseEx;

    @Resource
    PostDao postDao;

    @Test
    public void contextLoads() {
       System.out.println("--------------->>" + userDao.selectUserPermissionBylevel(3));
    }

    @Test
    public void testPostList() throws Exception {
        PostQueryForList queryForList = new PostQueryForList();
        List<Post> query = postDao.findQuery(queryForList);
        System.out.println(query);
    }

    @Test
    public void testChange() {
        PostResponse postResponse = new PostResponse();
        postResponse.setIfGood(2);
        numberChineseEx.NumExchangeChinese(postResponse, "ifGood");
    }

}