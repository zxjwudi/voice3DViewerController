package voice3DViewerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Voice3DViewerController {
	public final static int END_MARK = 0;

	/**
	 * ʹ��Runtime�����exec����������cmd���
	 */
	public static void main(String[] args) {
		int actionId = 0;
		Runtime rt = Runtime.getRuntime();
		try {		
			Process pr = rt.exec("HVite.exe -C config_online -l * -p -50 -T 1 -t 250.0 -s 15  -H .\\macros -H .\\hmmdefs -w wdnet phone.dct zs_tied_tri4.tri4"); //����cmd����	
			while(true){
		BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String s = br.readLine();
			String temp = "" ;
			String action = " ";
			String ss = "Read 1811 physical / 2215 logical HMMs";
			//System.out.println(s);
			while (null != s){
			System.out.println("Please give me your order!");	
			while(null != s ){	
				if(!"".equals(s.trim()))  temp = s;      
			        String regex = "SENT-START (.*) SENT-END";
			        Pattern pattern = Pattern.compile(regex);
			        Matcher matcher = pattern.matcher(s);
			        while (matcher.find()) {
			           System.out.println(action = matcher.group(1));
			            switch (action) {
			            case "上":
			            	actionId = 1;
			            	System.out.println(actionId);break;
			            case "下":
			            	actionId = 2;
			            	System.out.println(actionId);break;
			            case "左":
			            	actionId = 3;
			            	System.out.println(actionId);break;
			            case "右":
			            	actionId = 4;
			            	System.out.println(actionId);break;
			            case "上移":
			            	actionId = 5;
			            	System.out.println(actionId);break;
			            case "下移":
			            	actionId = 6;
			            	System.out.println(actionId);break;
			            case "向左":
			            	actionId = 7;
			            	System.out.println(actionId);break;
			            case "向右":
			            	actionId = 8;
			            	System.out.println(actionId);break;
			            case "小":
			            	actionId = 9;
			            	System.out.println(actionId);break;
			            case "大":
			            	actionId = 10;
			            	System.out.println(actionId);break;
			            default:break;
			            }
			            
			        }
				//System.out.println(s);
				s = br.readLine();
			}
			}
			//br.close();
			//���µ�ǰ�̵߳ȴ�����Ҫ��һֱҪ�ȵ��ɸ� Process �����ʾ�Ľ���Ѿ���ֹ��
			pr.waitFor(); 
			//�� Process �����ʾ���ӽ�̵ĳ���ֵ����ݹ���ֵ 0 ��ʾ����ֹ��
			if (END_MARK == pr.exitValue()) {
				JOptionPane.showMessageDialog(null, temp );
			}
	     }
	      //br.close();	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

	
