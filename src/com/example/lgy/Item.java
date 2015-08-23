package com.example.lgy;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述一个详细条目的PO
 *
 * @author Atomic
 */
public class Item {
    private String id; //id
    private String name;//名字
    private String iconPath;//图片路径
    private String finalDate;//过期时间
    private List<String> tags = Lists.newArrayList();//标签们
    private String size;
    private int quantity;
    private String buytime;
    private String description;

    public Item() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String finalDate, String iconPath, String id, String name, List<String> tags,String size,int quantity,String buytime,String description) {
        this.finalDate = finalDate;
        this.iconPath = iconPath;
        this.id = id;
        this.name = name;

        this.tags = tags;
        this.size =size;
        this.quantity =quantity;
        this.buytime =buytime;
        this.description =description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Item)) {
            return false;
        }
        Item target = (Item) o;

        return Objects.equal(target.id, this.id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .toString();
    }

    public void copyNewValue(Item item) {
        this.finalDate = item.finalDate;
        this.iconPath = item.iconPath;
        this.name = item.name;
        this.tags = item.tags;
        this.description =item.description;
        this.buytime =item.buytime;
        this.quantity =item.quantity;
        this.size =item.size;
    }

}
