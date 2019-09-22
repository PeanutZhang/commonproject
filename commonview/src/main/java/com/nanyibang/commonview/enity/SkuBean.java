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

    public String type;
    public int id;
    public int optional;
    public String price;
    public List<ValuesBean> values;

    public static class ValuesBean {
        /**
         * name : 颜色
         * value : ["黑拼黄","黑拼绿","白拼红"]
         * key : color
         */

        public String name;
        public String key;
        public List<String> value;
    }
}
