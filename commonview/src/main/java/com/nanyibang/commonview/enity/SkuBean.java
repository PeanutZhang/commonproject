package com.nanyibang.commonview.enity;

import java.util.List;

/**
 * @Package: com.nanyibang.commonview.enity
 * @Description:
 * @Author: zyh
 * @CreateDate: 2019-09-2019/9/22
 * @company: 上海若美科技有限公司
 */
public class SkuBean {

    /**
     * type : 连帽卫衣
     * values : [{"name":"颜色","value":["黑拼黄","黑拼绿","白拼红"],"key":"color"},{"name":"尺码","value":["M","L","XL","2XL"],"key":"size"}]
     * id : 988
     * optional : 0
     * price : 179.00
     */

    private String type;
    private int id;
    private int optional;
    private String price;
    private List<ValuesBean> values;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOptional() {
        return optional;
    }

    public void setOptional(int optional) {
        this.optional = optional;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ValuesBean> getValues() {
        return values;
    }

    public void setValues(List<ValuesBean> values) {
        this.values = values;
    }

    public static class ValuesBean {
        /**
         * name : 颜色
         * value : ["黑拼黄","黑拼绿","白拼红"]
         * key : color
         */

        private String name;
        private String key;
        private List<String> value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
