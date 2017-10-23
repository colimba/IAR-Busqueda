/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iar.busqueda.logica;

/**
 *
 * @author Andres
 */
public class NodeTree <T extends Comparable>
{
   private T info;
   private NodeTree <T> izq, der;
   
   /**
      Constructor por defecto.
   */
   public NodeTree ()
   {
   }
   
   /**
      Inicializa los atributos tomando los valores de los parametros.
      @param x el info del nuevo nodo.
      @param iz la direccion del hijo izquierdo.
      @param de la direccion del hijo derecho.
   */
   public NodeTree(T x, NodeTree <T> iz, NodeTree <T> de)
   {
       info = x;
       izq  = iz;
       der  = de;
   }

   /**
      Modificador del info.
      @param x nuevo valor del info.
   */
   public void setInfo (T x)
   {
      info = x;
   }

   /**
      Modificador de la direccion del subarbol izquierdo.
      @param iz nuevo valor del atributo izq.
   */
   public void setIzquierdo (NodeTree <T> iz)
   {
      izq = iz;
   }

   /**
      Modificador de la direccion del subarbol derecho.
      @param de nuevo valor del atributo der.
   */
   public void setDerecho (NodeTree <T> de)
   {
      der = de;
   }

   /**
      Acceso al info.
      @return valor del info.
   */
   public T getInfo ()
   {
      return info;
   }

   /**
      Acceso a la direccion del subarbol izquierdo.
      @return valor de la direccion del subarbol izquierdo.
   */
   public NodeTree <T> getIzquierdo ()
   {
      return izq;
   }

   /**
      Acceso a la direccion del subarbol derecho
      @return valor de la direccion del subarbol derecho
   */
   public NodeTree <T> getDerecho ()
   {
      return der;
   }

   /**
     Redefinicion de toString.
     @return representacion del contenido del nodo como un String.
   */
   @Override
   public String toString()
   {
     return info.toString();
   }
}

