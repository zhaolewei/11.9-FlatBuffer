// automatically generated by the FlatBuffers compiler, do not modify

package com.zlw.a119_flatbuffer2.flatmodel;

import com.zlw.utils.flatbuffer.FlatBufferBuilder;
import com.zlw.utils.flatbuffer.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Student extends Table {
    public static Student getRootAsStudent(ByteBuffer _bb) {
        return getRootAsStudent(_bb, new Student());
    }

    public static Student getRootAsStudent(ByteBuffer _bb, Student obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public Student __init(int _i, ByteBuffer _bb) {
        bb_pos = _i;
        bb = _bb;
        return this;
    }

    public int id() {
        int o = __offset(4);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public String name() {
        int o = __offset(6);
        return o != 0 ? __string(o + bb_pos) : null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public static int createStudent(FlatBufferBuilder builder,
                                    int id,
                                    int nameOffset) {
        builder.startObject(2);
        Student.addName(builder, nameOffset);
        Student.addId(builder, id);
        return Student.endStudent(builder);
    }

    public static void startStudent(FlatBufferBuilder builder) {
        builder.startObject(2);
    }

    public static void addId(FlatBufferBuilder builder, int id) {
        builder.addInt(0, id, 0);
    }

    public static void addName(FlatBufferBuilder builder, int nameOffset) {
        builder.addOffset(1, nameOffset, 0);
    }

    public static int endStudent(FlatBufferBuilder builder) {
        int o = builder.endObject();
        return o;
    }
}

