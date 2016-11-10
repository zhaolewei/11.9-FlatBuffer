##1、为什么要用Google FlatBuffers
    与Protocol Buffers相比，尽管FlatBuffers在空间使用上不具有优势，但是反序列化上的性能非常彪悍！
这得益于FlatBuffers不需要打包/解包。它的结构化数据都以二进制形式保存，不需要数据解析过程，数据也可以方便传递。
##2、编译&安装

flatc.exe文件：

https://github.com/google/flatbuffers/releases

之后执行命令：    flatc -j -b ./Items.fb      生成java文
解释:           -j 目标语言为java（生成.java文件） 
         -c:生成.h文件
         -b:二进制文件  

##3、生成java model类
1.编写Schema（*.fb/*.fbs）

````
namespace TestApp;
table Student{
id:int;
name:string;
}
table TestObj {
 code:int;
 list:[Student];
}
root_type TestObj;
````
2.使用flatc.exe 编译Schema

执行：
````
flatc -j -b ./Students.fb
````
生成：TestObj.java 和 Student.java两个
3、序列化

     目标数据：
       
         TestObj ：{code：1;list<Student>}
       list<Student>:{stu1,stu2,stu3}
          stu1：{id:1;name:zlw}...

      开始序列化：

````
FlatBufferBuilder builder = new FlatBufferBuilder();
int id1 = builder.createString("zlw1"); //获取字符串的偏移量（指针）
//开始造人
int studentID1 = Student.createStudent(builder, 1, id1);
int studentID2 = Student.createStudent(builder, 2, builder.createString("zlw2"));
int studentID3 = Student.createStudent(builder, 3, builder.createString("zlw3")); 
//封装集合
int[] list = {studentID1, studentID2, studentID3}; //封装类中的数据指针的集合（同json的datas）
int listID = TestObj.createListVector(builder, list);//封装成封装类
TestObj.startTestObj(builder);
TestObj.addList(builder, listID);
int rootID = TestObj.endTestObj(builder);
TestObj.finishTestObjBuffer(builder, rootID);
ByteBuffer data = builder.dataBuffer();
Log.i("zlw", "序列化完成");

````
总之它的存储结构为：   索引->数据 的一维数据       索引视为数据即可  

3、反序列化
````
TestObj obj = TestObj.getRootAsTestObj(data);
for (int i = 0; i < obj.listLength(); i++) {
    Student s = obj.list(i);
    Log.i("zlw", "学生" + i + ":姓名：" + s.name());
    //TODO:构建List
}
````
通过flatc构建的java类一次进行解析即可

 
##4、封装使用
//TODO:













