package com.bysj.bbsv1;

import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.dao.*;
import com.bysj.entity.FavoritesArticle;
import com.bysj.entity.Post;
import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.entity.vo.response.ReplyForPostDetail;
import com.bysj.service.IPostService;
import com.bysj.service.IReplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.PriorityQueue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bbsv1ApplicationTests {
    @Resource
    UserDao userDao;
    @Autowired
    IPostService postService;

    @Resource
    NumberChineseEx numberChineseEx;

    @Autowired
    IReplyService replyService;

    @Resource
    PostDao postDao;
    @Resource
    FavoritesArticleDao favoritesArticleDao;

    @Resource
    private ApplyPlateDao applyPlateDao;

    @Resource
    private PrivateLetterDao privateLetterDao;

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
        numberChineseEx.numExchangeChinese(postResponse, "ifGood");
    }

    @Test
    public void testPostDetail() {
        PostDetailResponse postDetailResponse = postDao.findPostDetail(1);
        postDetailResponse.setArticleFromStr(numberChineseEx.numExchangeChinese(postDetailResponse,"articleFrom"));
        postDetailResponse.setArticleTypeStr(numberChineseEx.numExchangeChinese(postDetailResponse,"articleType"));
        postDetailResponse.setIfGoodStr(numberChineseEx.numExchangeChinese(postDetailResponse,"ifGood"));
        System.out.println(postDetailResponse);
    }

    @Test
    public void getDetailReply() {
        List<ReplyForPostDetail> replys = postDao.findReplyForPost(1);
        replys.forEach(item -> {
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(),DateUtils.WHOLE_FORMAT));
            System.out.println(item.getGmtCreateStr());
        });
    }


    @Test
    public void addNewReply() throws Exception {
        ReplyRequest replyRequest = new ReplyRequest();
        replyRequest.setPostId(2);
        replyRequest.setReplyInfo("你好");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(replyService.saveReply(replyRequest));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Test
    public void testFav() {
        System.out.println("--------------------------------");
        System.out.println(favoritesArticleDao.getByTwoId(1, 35).toString());
    }

    @Test
    public void testgetFA() {
        FavoritesArticle byTwoId = favoritesArticleDao.getByTwoId(1, 37);
        System.out.println(byTwoId);
    }

    @Test
    public void testgetInfoByUserIdAndPlateId() {
        System.out.println("----------------------");
        System.out.println(applyPlateDao.getInfoByUserIdAndPlateId(3,15));
        System.out.println("----------------------");
    }

    @Test
    public void testGetAllPL() throws Exception {
        PrivateLetterQuery privateLetterQuery = new PrivateLetterQuery();
        System.out.println(privateLetterDao.findQuery(privateLetterQuery));
    }

}