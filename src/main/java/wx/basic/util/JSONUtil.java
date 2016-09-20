package wx.basic.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;


public class JSONUtil {
	public static String output4ajax(Object[] o){
		String s= "";
		try{
			
			for(int i=0;i<o.length;i++){
			if(o[i] instanceof List){
			    s = s+JSONUtil.getListJSON4ajax((List) o[i])+",";
			}
			else if(o[i] instanceof String){
				s = s + o[i].toString()+",";
			}
			else{
			   s =  s + JSONUtil.getObjectJSON(o[i])+",";
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
			
		   return s.substring(0,s.length()-1);
		
	}
	/**
	 * List中的单个对象，不带对象名
	 *kk
	 * @author vector
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private static String getJSON(Object o) throws Exception {

		Field fields[] = o.getClass().getDeclaredFields();
		String s = "{\"";
		String className = o.getClass().getName();
		className = className.substring(className.lastIndexOf('.') + 1);
		String id = "";
		String type = "";
		if (!isTree(className)) {
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				Object val;
				f.setAccessible(true);// 设置些属性是可以访问的
				if (f.get(o) instanceof Date) {
					val = StringFormatter.getFormattedDate(f.get(o));
				} else if (f.getName().equalsIgnoreCase("sex")) {
					val = f.get(o).toString().equals("0") ? "男" : "女";
				} else if (f.getName().equalsIgnoreCase("status")) {
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "已用";
					} else if (val.equals("1")) {
						val = "未用 ";
					} else if (val.equals("3")) {
						val = "报废";
					}
				}else if(f.getName().equalsIgnoreCase("processStatus")){
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "已确认";
					} else if (val.equals("1")) {
						val = "未审核";
					} else if (val.equals("3")) {
						val = "已取消";
					}else if (val.equals("4")){
						val = "已完成";
					}
				}else if(f.getName().equalsIgnoreCase("proceStatus")){
					val = f.get(o).toString().toString();
					if (val.equals("1")) {
						val = "待处理";
					} else if (val.equals("2")) {
						val = "已处理";
					} else if (val.equals("3")) {
						val = "不予处理";
					}else if (val.equals("4")){
						val = "处理中";
					}
				}  
				else if(f.getName().equalsIgnoreCase("processState")){
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "未处理";
					} else if (val.equals("1")) {
						val = "已处理";
					}
				} else if (f.getName().equalsIgnoreCase("reviewStatus")) {
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "审核入库";
					} else if (val.equals("1")) {
						val = "未审核";
					} else if (val.equals("3")) {
						val = "审核无效";
					}
				} else if (f.getName().equalsIgnoreCase("state")) {
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "禁用";
					} else if (val.equals("1")) {
						val = "启用";
					} 
				}  else if (f.getName().equalsIgnoreCase("isRemind")) {
						val = f.get(o).toString().toString();
						if (val.equals("2")) {
							val = "否";
						} else if (val.equals("1")) {
							val = "是";
						} 
				} else if (f.getName().equalsIgnoreCase("newStatus")) {
					val = f.get(o).toString().toString();
					if(val.equals("0")) {
						val = "待审核";
					}else if (val.equals("1")) {
						val = "未通过";
					} else if (val.equals("2")) {
						val = "已通过未备货";
					} else if (val.equals("3")) {
						val = "备货中";
					} else if (val.equals("4")) {
						val = "备货完成未发货";
					} else if (val.equals("5")) {
						val = "发货中";
					} else if (val.equals("6")) {
						val = "已发货";
					}
				}else if (f.getName().equalsIgnoreCase("hasDone")) {
					val = f.get(o).toString().toString();
					if (val.equals("2")) {
						val = "否";
					} else if (val.equals("1")) {
						val = "是";
					} 
				}else if (f.getName().equalsIgnoreCase("personStatus")) {
					val = f.get(o).toString().toString();
					if (val.equals("0")) {
						val = "在职";
					} else if (val.equals("1")) {
						val = "离职";
					} 
				}else if (f.getName().equalsIgnoreCase("goodsStatus")) {
					val = f.get(o).toString().toString();
					if (val.equals("1")) {
						val = "已下架";
					} else if (val.equals("0")) {
						val = "已上架";
					} 
				}else {
					if (f.get(o) != null)
						val = (f.get(o)).toString().replace("\"", "&quot;")
								.replace("\r\n", "<br>").replace("\n", "<br>").replace("\r", "<br>");// 得到此属性的值
					else
						val = "";
				}
				s = s + f.getName() + "\":\"" + val + "\",\"";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "}";
		}else {
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				String treeFieldName = "";
				Object val = null;
				f.setAccessible(true);// 设置些属性是可以访问的
				val = f.get(o); // 得到此属性的值
				if (f.getName().equals("id")) {
					treeFieldName = "id";
				} else if (f.getName().equals("name")) {
					treeFieldName = "text";
				} else if (f.getName().equals("parentId")) {
					treeFieldName = "parentId";
				} else if (f.getName().equals("type")) {
					treeFieldName = "type";
				}else if(f.getName().equals("orderCode")){
					treeFieldName = "orderCode";
				}else if(f.getName().equals("region_code")){
					treeFieldName = "region_code";
				}else if(f.getName().equals("regionName")){
					treeFieldName = "text";
				}else if(f.getName().equals("regionCode")){
					treeFieldName = "id";
				}else if(f.getName().equals("fatherCode")){
					treeFieldName = "parentId";
				}else if(f.getName().equals("gcCode")){
					treeFieldName = "id";
				}
				if (!treeFieldName.equals("")){
					String lal = "";
					lal = val.toString().replace("\"", "&quot;");
					
					s = s + treeFieldName + "\":\"" + lal + "\",\"";
				}
			}
			s = s + "state\":\"closed\",";
			s = s.substring(0, s.lastIndexOf(',')) + "}";
		}
		return s;
	}

	private static String getIconCls(Object type) {
		String str = "";
		switch ((int) type) {
		case 1:
			str = "iconCls\":\"logic_iconCls\",\"";
			break;
		case 2:
			str = "iconCls\":\"area_iconCls\",\"";
			break;
		case 3:
			str = "iconCls\":\"dealer_iconCls\",\"";
			break;
		}
		return str;
		
	}

	/**
	 * 以URL方式返回List类型的JSON串
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String getListJSON4url(List list) throws Exception {
		String s = "[";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				s = s + getJSON(o) + ",";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "]";
		} else
			s = s + "]";
		return s;
	}

	/**
	 * 以URL方式返回List类型的JSON串
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String getListJSON4url(List list, int pageSize, int pageNo)
			throws Exception {
		String s = "[";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				String jsonString = getJSON(o);
				int index = pageSize * (pageNo - 1) + i + 1;
				jsonString = jsonString.substring(0, jsonString.length() - 1)
						+ ",\"index\":" + "\"" + index + "\"}";
				s = s + jsonString + ",";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "]";
		} else
			s = s + "]";
		return s;
	}

	/**
	 * 以URL方式返回List类型的JSON串
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String getListJSON4ajax(List list) throws Exception {
		String s = "{list:[";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);

				s = s + getJSON(o) + ",";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "]}";
		} else {
			s = s + "]}";
		}
		return s;
	}

	/**
	 * 以URL方式返回List类型的JSON串
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String getListJSON4ajax(List list, int pageSize, int pageNo)
			throws Exception {
		String s = "{list:[";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				String jsonString = getJSON(o);
				int index = pageSize * (pageNo - 1) + i + 1;
				jsonString = jsonString.substring(0, jsonString.length() - 1)
						+ ",\"index\":" + "\"" + index + "\"}";
				s = s + jsonString + ",";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "]}";
		} else {
			s = s + "]}";
		}
		return s;
	}

	/**
	 * 将普通对象转换成json格式
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static String getObjectJSON(Object o) throws Exception {

		String s = "{\"";
		if (o != null) {
			String instName = o.getClass().getName();
			instName = instName.substring(instName.lastIndexOf('.') + 1);
			String temp = instName.substring(0, 1);
			instName = temp.toLowerCase() + instName.substring(1);
			Field fields[] = o.getClass().getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				Object val;
				f.setAccessible(true);// 设置些属性是可以访问的
				if (f.get(o) instanceof Date) {
					val = StringFormatter.getFormattedDate(f.get(o));
				} else {
					val = f.get(o); // 得到此属性的值
				}
				if(val == null){
					s = s + instName + "." + f.getName() + "\":\"" + val + "\",\"";
				}else{
					String kkk = val.toString().replace("\"", "&quot;")
							.replace("\r\n", "<br>");
					s = s + instName + "." + f.getName() + "\":\"" + kkk + "\",\"";
				}
				
			}
			s = s.substring(0, s.lastIndexOf(',')) + "}";
		}
		return s;
	}

	private static boolean isTree(String str) {
		boolean flag = false;
		String[] tree = { "Department", "GoodsClassify","MarketSurveyClassify","SystemRoleRelRightView",
			 "CustomerClassify","SystemRight","CustomerTypeView","CustomerClassifyUtilView","StoreAreas","GoodsClass"};
		for (int i = 0; i < tree.length; i++) {
			if (str.equals(tree[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 复合对象转换
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static String getComplexJson(Object o) throws Exception {
		String s = "";
		if (o != null) {
			s = "{\"";
			String instName = o.getClass().getName();
			instName = instName.substring(instName.lastIndexOf('.') + 1);
			String temp = instName.substring(0, 1);
			instName = temp.toLowerCase() + instName.substring(1);
			Field fields[] = o.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				Object val;
				f.setAccessible(true);// 设置些属性是可以访问的
				if (f.get(o) instanceof Date) {
					val = StringFormatter.getFormattedDate(f.get(o));
				} else if (f.getName().equalsIgnoreCase("sex")) {
					val = f.get(o).toString().equals("0") ? "男" : "女";
				} else if (f.get(o) instanceof List) {
					val = getComplexJSON4ajax((List) f.get(o));
				} else {
					val = f.get(o); // 得到此属性的值
				}
				s = s + instName + "." + f.getName() + "\":\"" + val + "\",\"";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "}";
		}
		return s;
	}

	public static String getComplexJSON4ajax(List list) throws Exception {
		String s = "[";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				s = s + getJSON(o) + ",";
			}
			s = s.substring(0, s.lastIndexOf(',')) + "]";
		}
		return s;
	}

}
