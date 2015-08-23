package com.example.lgy;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 操作数据仓库的统一接口
 *
 * @author Atomic
 */
public class JsonRepository {
    private static final String REPO_NAME = "data.json";

    private static JsonRepository sInstance;

    private static Context mContextHolder;

    private JsonRepository(Context context) {
        mContextHolder = context;
    }

    public static JsonRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new JsonRepository(context);
        }

        return sInstance;
    }

    /**
     * 根据id查询
     */
    public Item findById(String id) {
        try {
            List<Item> source = loadFromFileStore();

            Item temp = new Item();
            temp.setId(id);

            int index = source.indexOf(temp);
            if (index == -1) {
                return null;
            }

            return source.get(index);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 根据tags
     */
    public List<Item> findByTags(String... tags) {

        try {
            List<Item> source = loadFromFileStore();
            return FluentIterable
                    .from(source)
                    .filter(filterTags(tags))
                    .toList();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 从文件系统中加载数据
     */
    private List<Item> loadFromFileStore() throws IOException {
        File root = mContextHolder.getExternalFilesDir(null);

        File target = new File(root, REPO_NAME);

        if (!Files.isFile().apply(target)) {
            return Lists.newArrayList();
        }

        String jsonRaw = Files.toString(target, Charsets.UTF_8);
        return JSON.parseArray(jsonRaw, Item.class);
    }

    /**
     * 重新持久化进文件系统
     *
     * @param item 根据id查询,如果存在则修改,否则新增
     */
    public void persitToFileStore(Item item) {

        try {
            List<Item> dataSources = loadFromFileStore();

            int index = dataSources.indexOf(item);

            if (index == -1) {
                dataSources.add(item);
            } else {
                Item origin = dataSources.get(index);
                origin.copyNewValue(item);
            }

            File root = mContextHolder.getFilesDir();
            File target = new File(root, REPO_NAME);

            Files.write(JSON.toJSONString(dataSources), target, Charsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Predicate<Item> filterTags(final String... tags) {

        return new Predicate<Item>() {

            public boolean apply(Item item) {

                for (String tag : tags) {
                    return item.getTags().contains(tag);
                }
                return false;
            }
        };
    }

}
