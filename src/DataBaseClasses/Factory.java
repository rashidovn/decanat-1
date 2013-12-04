/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

/**
 *
 * @author Roma
 */
public class Factory {
    private static ActionMethods actionMethods = null;
       private static Factory instance = null;

       public static synchronized Factory getInstance(){
             if (instance == null){
               instance = new Factory();
             }
             return instance;
       }

       public ActionMethods getActionMethods(){
             if (actionMethods == null){
               actionMethods = new DBCommands();
             }
             return actionMethods;
       }  
}
