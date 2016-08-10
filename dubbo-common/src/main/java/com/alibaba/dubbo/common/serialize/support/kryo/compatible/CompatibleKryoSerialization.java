/**
 * @项目名称: dubbo-parent
 * @Date: 16/8/10
 * @Copyright: 2016 Jiayin Financial Service Inc. All rights reserved.
 * 注意：本内容仅限于嘉银企业征信服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.alibaba.dubbo.common.serialize.support.kryo.compatible;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.OptimizedSerialization;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoFactory;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoObjectInput;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoObjectOutput;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;

/**
 * Created by dachao on 16/8/10.
 */
public class CompatibleKryoSerialization implements OptimizedSerialization {

    public byte getContentTypeId() {
        return 10;
    }

    public String getContentType() {
        return "x-application/kryo";
    }

    public ObjectOutput serialize(URL url, OutputStream out) throws IOException {
        return new KryoObjectOutput(out, getCompatibleKryo());
    }

    public ObjectInput deserialize(URL url, InputStream is) throws IOException {
        return new KryoObjectInput(is, getCompatibleKryo());
    }

    private static Kryo getCompatibleKryo() {
        final Kryo kryo = new Kryo();
        kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
        KryoFactory.getDefaultFactory().registerAdditionalSerializer(kryo);
        return kryo;
    }
}