/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.lang.annotation.*;
import java.lang.reflect.*;
/**
 *
 * @author Mirado
 */
public class Utilitaire {
    
     public Method getMethodByAnnotation(Class classe,Class annotationClass,String nameMethod,String value)throws Exception{
        Method[] methods=classe.getDeclaredMethods();
        Method methodtemp=null;
        Annotation annotation=null;
        String valueStr="";
        for(int i=0;i<methods.length;i++){
            annotation=methods[i].getAnnotation(annotationClass);
            if(annotation!=null){
                methodtemp=annotation.getClass().getDeclaredMethod("name", null);
                if(methodtemp!=null){
                    valueStr=methodtemp.invoke(annotation, null).toString();
                    if(valueStr!=null){
                        if(valueStr.compareToIgnoreCase(value)==0){
                            return methods[i];
                        }
                    }
                }
            }
        }
        return null;
     }
     
     //    public static Object getValueAnnotation(Object object, Class annotationClass, String nameMethod) throws Exception {
//      Annotation annotation = object.getClass().getAnnotation(annotationClass);
//      if (object instanceof Field) {
//         Field field = (Field) object;
//         annotation = field.getAnnotation(annotationClass);
//      }else if( object instanceof Method ){
//         Method method = (Method) object;
//         annotation = method.getAnnotation(annotationClass);
//      }else if( object instanceof Class ){
//         Class theClass=(Class)object;
//         annotation = theClass.getAnnotation(annotationClass);
//      }
//      // //System.out.println(annotation.annotationType());
//      if(annotation==null){ return null; }
//      Method[] m = annotation.annotationType().getDeclaredMethods();
//      Object value = null;
//      for (int i = 0; i < m.length; i++) {
//         if (nameMethod.compareTo(m[i].getName()) == 0) {
//            value = m[i].invoke(annotation);
//            if(value instanceof String[]){
//            String[] dd=(String[])value;
//            System.out.println("nameMethode -----> "+m[i]+"----------arg:"+nameMethod+"-----------value-----:"+dd);
//            }
//            // //System.out.println("valeur -----> "+value);
//         }
//      }
//      return value;
//   }
//    public static boolean isClassAnnotedAndWithValue(Class classe,Class annotationClass,String nameMethod,String value)throws Exception{
//        Annotation annotation=null;
//        annotation=classe.getAnnotation(annotationClass);
//        if(annotation==null){ return false; }
//        Object valeur=getValueAnnotation(classe,annotationClass, nameMethod);
//        String valeurS=(String)valeur;
//        if(value.compareToIgnoreCase(valeurS)==0){ return true; }
//        else{ return false; }
//     }
}
