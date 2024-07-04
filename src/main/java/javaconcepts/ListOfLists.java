package javaconcepts;

import java.util.ArrayList;
import java.util.List;

import utilities.LoggerClass;

public class ListOfLists {

	public static void main(String[] args) {
		LoggerClass loggerObj = new LoggerClass();
//		loggerObj.setDefaults();
		loggerObj.setLogName("testlog");
		
		loggerObj.info("Hello world");
		// TODO Auto-generated method stub
		List<List<Object>> datalist = new ArrayList<>();

		 // Adding objects to the list
        List<Object> case1 = new ArrayList<>();
        case1.add("624574");
        case1.add("2023-05-25");
        case1.add("RFQ");
        case1.add("yes");
        case1.add("received");
        datalist.add(case1);

        // Adding 10 more cases
        List<Object> case2 = new ArrayList<>();
        case2.add("624575");
        case2.add("2023-05-26");
        case2.add("RFQ");
        case2.add("no");
        case2.add("not received");
        datalist.add(case2);

        List<Object> case3 = new ArrayList<>();
        case3.add("624576");
        case3.add("2023-05-27");
        case3.add("PO");
        case3.add("yes");
        case3.add("shipped");
        datalist.add(case3);

        List<Object> case4 = new ArrayList<>();
        case4.add("624577");
        case4.add("2023-05-28");
        case4.add("PO");
        case4.add("no");
        case4.add("pending");
        datalist.add(case4);

        List<Object> case5 = new ArrayList<>();
        case5.add("624578");
        case5.add("2023-05-29");
        case5.add("Invoice");
        case5.add("yes");
        case5.add("paid");
        datalist.add(case5);
        
        
        
        System.out.println(datalist.size());
        System.out.println(datalist.get(1).get(0));
        System.out.println(datalist.get(1).get(1));
        System.out.println(datalist.get(1));
	}

}
