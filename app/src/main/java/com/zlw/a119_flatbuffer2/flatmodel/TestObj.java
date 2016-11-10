// automatically generated by the FlatBuffers compiler, do not modify

package com.zlw.a119_flatbuffer2.flatmodel;

import com.zlw.utils.flatbuffer.FlatBufferBuilder;
import com.zlw.utils.flatbuffer.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class TestObj extends Table {
    public static TestObj getRootAsTestObj(ByteBuffer _bb) {
        return getRootAsTestObj(_bb, new TestObj());
    }

    public static TestObj getRootAsTestObj(ByteBuffer _bb, TestObj obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public TestObj __init(int _i, ByteBuffer _bb) {
        bb_pos = _i;
        bb = _bb;
        return this;
    }

    public int code() {
        int o = __offset(4);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public Student list(int j) {
        return list(new Student(), j);
    }

    public Student list(Student obj, int j) {
        int o = __offset(6);
        return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null;
    }

    public int listLength() {
        int o = __offset(6);
        return o != 0 ? __vector_len(o) : 0;
    }

    public static int createTestObj(FlatBufferBuilder builder,
                                    int code,
                                    int listOffset) {
        builder.startObject(2);
        TestObj.addList(builder, listOffset);
        TestObj.addCode(builder, code);
        return TestObj.endTestObj(builder);
    }

    public static void startTestObj(FlatBufferBuilder builder) {
        builder.startObject(2);
    }

    public static void addCode(FlatBufferBuilder builder, int code) {
        builder.addInt(0, code, 0);
    }

    public static void addList(FlatBufferBuilder builder, int listOffset) {
        builder.addOffset(1, listOffset, 0);
    }

    public static int createListVector(FlatBufferBuilder builder, int[] data) {
        builder.startVector(4, data.length, 4);
        for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]);
        return builder.endVector();
    }

    public static void startListVector(FlatBufferBuilder builder, int numElems) {
        builder.startVector(4, numElems, 4);
    }

    public static int endTestObj(FlatBufferBuilder builder) {
        int o = builder.endObject();
        return o;
    }

    public static void finishTestObjBuffer(FlatBufferBuilder builder, int offset) {
        builder.finish(offset);
    }
}
