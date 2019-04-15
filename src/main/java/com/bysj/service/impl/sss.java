package com.bysj.service.impl;

import com.bysj.common.request.ObjectQuery;
import com.google.common.base.Strings;

import java.util.*;

/**
 * 描述：
 **/
public class sss {
    static class Tag {
        private int id;
        private int fatherId;

        public Tag() {
        }

        public Tag(int id, int fatherId) {
            this.id = id;
            this.fatherId = fatherId;
        }

        public int getId() {

            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFatherId() {
            return fatherId;
        }

        public void setFatherId(int fatherId) {
            this.fatherId = fatherId;
        }
    }
    public static void main(String[] args) {
        Tag tag1 = new Tag(2,3);
        Tag tag2 = new Tag(4,2);
        Tag tag3 = new Tag(7, 6);
        Tag tag4 = new Tag(5,1);
        Tag tag5 = new Tag(3,0);
        Tag tag6 = new Tag(6, 2);
        Tag tag7 = new Tag(1,4);


        List<Tag> tags = new LinkedList<>();
        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        tags.add(tag4);
        tags.add(tag5);
        tags.add(tag6);
        tags.add(tag7);

        List<LinkedList<Tag>> func = func(tags);

    }

    public static List<LinkedList<Tag>> func(List<Tag> tags){
        List<LinkedList<Tag>> result = new LinkedList<>();
        List<Tag> oneLineOfResult = new LinkedList<>();
        Tag[] tagArr = tags.toArray(new Tag[0]);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < tagArr.length; i++) {
            strings.add(getValue(tagArr, i));
        }

        // 去重处理，此时strings包含所有的链条有23，3，423等。
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (strings.get(j).contains(strings.get(i))) {
                    strings.remove(i);
                } else if (strings.get(i).contains(strings.get(j))){
                    strings.remove(j);
                }
            }
        }
        System.out.println(strings);
        return null;
    }

    /**
     *
     * @param tags 如果fatherId不等于0，则返回当前节点如（2，3）的2+id为3的父节点的id，依次循环取父节点id，直至父节点fatherId=0，就可以返回id了
     * @param index 当前节点下标,从0开始一个一个找到对应的链条
     * @return
     */
    private static String getValue(Tag[] tags, int index) {
        if (tags[index].getFatherId() == 0) {
            return String.valueOf(tags[index].getId());
        } else {
            for (int i = 0; i < tags.length; i++) {
                // 找到该Tag的父类节点
                if (tags[i].getId() == tags[index].getFatherId() && i != index) {
                    return new StringBuilder().append(tags[index].getId()).append(getValue(tags, i)).toString();
                }
            }
        }

        return "NULL";
    }
}
