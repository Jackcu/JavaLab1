package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.util.JSONUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/**
 * Created by Jack on 5/20/2016.
 */
public class JsonTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JsonTest(String testName) {

        super(testName);

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(JsonTest.class);
    }


    public static class Person {
        private String mName;
        private int mAge;

        public Person() {

        }

        public Person(String name, int age) {
            mName = name;
            mAge = age;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public int getAge() {
            return mAge;
        }

        public void setAge(int age) {
            mAge = age;
        }
    }

    public static class Student {

        private Person mPerson;
        private String mClassName;
        private ArrayList<String> x = new ArrayList<String>() {{
            add("str01");
            add("str02");
        }};

        public Student() {

        }

        public ArrayList<String> getList() {

            return x;

        }

        public void setList(ArrayList<String> x1) {

            x = x1;

        }

        public Student(String name, int age, String className) {
            mPerson = new Person(name, age);
            mClassName = className;
        }

        public Person getPerson() {
            return mPerson;
        }


        public void setPerson(Person person) {
            mPerson = person;
        }

        public String getClassName() {
            return mClassName;
        }

        public void setClassName(String className) {
            mClassName = className;
        }

    }


    public void test_toJson() {


        List<Student> list2 = new ArrayList<Student>();

        list2.add(new Student("xiapi1", 10, "二"));
        list2.add(new Student("xiapi2", 10, "二"));
        list2.add(new Student("xiapi3", 10, "二"));

        JSONArray jsonArray2 = JSONArray.fromObject(list2);
        System.out.println("List<Student> list2");
        System.out.println(jsonArray2.toString(1, 0));

        Student st1 = new Student("xiapi1", 10, "二");
        st1.setPerson(new Person("三号", 111));

        JSONObject obj1 = JSONObject.fromObject(st1);
        System.out.println("Student");
        System.out.println(obj1.toString(1, 0));

        //region array to json
        int[] intArray = new int[]{1, 4, 5};
        JSONArray jsonArray1 = JSONArray.fromObject(intArray);
        System.out.println("int[] intArray");
        System.out.println(jsonArray1);

        boolean[] boolArray = new boolean[]{true, false, true};
        System.out.println("boolean[] boolArray");
        JSONArray jsonArray22 = JSONArray.fromObject(boolArray);
        System.out.println(jsonArray22);

        int[][] int2Array = new int[][]{{1, 2}, {3, 4}};
        JSONArray jsonArray3 = JSONArray.fromObject(int2Array);
        System.out.println("int[][] int2Array");
        System.out.println(jsonArray3);

        float[] floatArray = new float[]{0.1f, 0.2f, 0.3f};
        JSONArray jsonArray4 = JSONArray.fromObject(floatArray);
        System.out.println("float[] floatArray");
        System.out.println(jsonArray4);

        String[] strArray = new String[]{"hello", "hebut", "xiapi"};
        JSONArray jsonArray5 = JSONArray.fromObject(strArray);
        System.out.println("String[] strArray");
        System.out.println(jsonArray5);


        Student[] studentArr = new Student[3];

        studentArr[0] = new Student("xiapi1", 10, "二");
        studentArr[1] = new Student("xiapi11", 10, "二");
        studentArr[2] = new Student("xiapi111", 10, "二");

        JSONArray jsonArray6 = JSONArray.fromObject(studentArr);
        System.out.println("String[] studentArr");
        System.out.println(jsonArray6);

        //endregion

        //region map to json
        Map map1 = new HashMap();
        map1.put("name", "json");
        map1.put("bool", Boolean.TRUE);
        map1.put("int", new Integer(1));
        map1.put("arr", new String[]{"a", "b"});
        map1.put("func", "function(i){ return this.arr[i]; }");
        JSONObject jsonObject1 = JSONObject.fromObject(map1);
        System.out.println("Map map1");
        System.out.println(jsonObject1);

        Map<String, Student> map2 = new HashMap<String, Student>();
        map2.put("k1", new Student("xiapi1", 10, "二"));
        map2.put("k2", new Student("xiapi11", 10, "二"));
        map2.put("k3", new Student("xiapi111", 10, "二"));
        JSONObject jsonObject2 = JSONObject.fromObject(map2);
        System.out.println("Map<String,Student> map2");
        System.out.println(jsonObject2);


        //endregion


    }

    public void test_toCollection() {

        String json1 = "['first','second']";
        JSONArray jsonArray1 = (JSONArray) JSONSerializer.toJSON(json1);
        List output1 = (List) JSONSerializer.toJava(jsonArray1);
        System.out.println("List");
        System.out.println(output1.get(0));

        String json2 = "[{\"className\":\"二\",\"list\":[\"str01\",\"str02\"],\"person\":{\"age\":10,\"name\":\"xiapi1\"}},{\"className\":\"二\",\"list\":[\"str01\",\"str02\"],\"person\":{\"age\":10,\"name\":\"xiapi11\"}},{\"className\":\"二\",\"list\":[\"str01\",\"str02\"],\"person\":{\"age\":10,\"name\":\"xiapi111\"}}]";
        JSONArray jsonArray21 = JSONArray.fromObject(json2);
        List<Student> output2 = JSONArray.toList(jsonArray21, Student.class);

        System.out.println("List<Student>");
        System.out.println(output2.size());
        System.out.println(output2.get(0));
        System.out.println(output2.get(0).getClassName());

    }

    public void test_toBean() {

        //region 获取json
        Student student = new Student("cb", 24, "04050102");
        JSONObject object = JSONObject.fromObject(student);
        String json = object.toString();
        //endregion

        System.out.println(json);

        //region 直接转成复杂对象
        JSONObject jO = JSONObject.fromObject(object.toString());
        Object object2 = JSONObject.toBean(jO, Student.class);
        Student student2 = (Student) object2;
        System.out.println(student2.getPerson().getAge());
        //endregion

        //region 手动获取值

        String className = (String) jO.get("className");//其实对应的是getClassName方法
        System.out.println(className);//简单对象直接获取

        Person person = (Person) JSONObject.toBean(((JSONObject) jO.get("person")), Person.class);
        System.out.println(person.getAge());//复杂对象再剥一层皮

        JSONArray ja = (JSONArray) jO.get("list");
        ArrayList output1 = (ArrayList) JSONSerializer.toJava(ja);

        //endregion

    }

}
