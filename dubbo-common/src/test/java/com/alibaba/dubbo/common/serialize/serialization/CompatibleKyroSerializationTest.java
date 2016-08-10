/**
 * @项目名称: dubbo-parent
 * @Date: 16/8/10
 * @Copyright: 2016 Jiayin Financial Service Inc. All rights reserved.
 * 注意：本内容仅限于嘉银企业征信服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.alibaba.dubbo.common.serialize.serialization;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.dubbo.common.serialize.support.kryo.compatible.CompatibleKryoSerialization;

/**
 * Created by dachao on 16/8/10.
 */
public class CompatibleKyroSerializationTest extends AbstractSerializationTest {

    {
        serialization = new CompatibleKryoSerialization();
    }

    // Do not support class without default constructor
    @Ignore
    @Test
    public void test_BizExceptionNoDefaultConstructor() throws Exception {
    }

    // Do not support class without default constructor
    @Ignore
    @Test
    public void test_BizExceptionNoDefaultConstructor_WithType() throws Exception {
    }
}