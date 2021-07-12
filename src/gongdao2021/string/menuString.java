package gongdao2021.string;

import java.util.Stack;

/**
 * 还原菜单
 * */
public class menuString {
    public String simplifyPath(String path) {
        String[] menu = path.split("/");
        Stack<String> menuStack =new Stack<>();
        for(int i= 0;i<menu.length;i++){
            if("..".equals(menu[i])&&!menuStack.isEmpty()){
                menuStack.pop();
                //"..".equals(menu[i]) 上面存在stack 空 但是出现..的情况
            }else if(!".".equals(menu[i])&&!"".equals(menu[i])&&!"..".equals(menu[i])){
                menuStack.push(menu[i]);
            }
        }
        //处理完成
        if(menuStack.isEmpty()) return "/";
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<menuStack.size();i++){
            buf.append("/");
            buf.append(menuStack.get(i));
        }
        return buf.toString();
    }
}
