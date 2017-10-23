/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iar.busqueda.logica;

import java.awt.Component;

/**
 *
 * @author Andres
 */
public class TreeSearch <T extends Comparable>
{
    private NodeTree <T> raiz;
    private int cantidad;
        
    /**
      Constructor. Garantiza que el arbol arranca vacio.
    */
    public TreeSearch ()
    {
       raiz = null;
       cantidad = 0;
    }
    
    /**
      Inserta un objeto en el arbol. Si el objeto a insertar ya existia, no lo inserta y sale
      retornando false. Si no existia, lo inserta y retorna true. 
      @return true si el objeto pudo insertarse - false en caso contrario.
      @param x el objeto a insertar.
    */
    public boolean add (T x)
    {
        if(x == null) { return false; }
        
        NodeTree <T> p = raiz, q = null;
        while(p != null)
        {
            T y = p.getInfo();
            if(x.compareTo(y) == 0) { break; }
            
            q = p;
            if(x.compareTo(y) < 0) { p = p.getIzquierdo(); }
            else { p = p.getDerecho(); }
        }
       
        // si ya existia... retorne false.
        if(p != null) { return false; }
       
        // si no existia... hay que insertarlo.
        NodeTree <T> nuevo = new NodeTree (x, null, null);
        if(q == null) { raiz = nuevo; }
        else 
        {
           if (x.compareTo(q.getInfo()) < 0) { q.setIzquierdo(nuevo); }
           else { q.setDerecho(nuevo); }
        }
        cantidad++;
       
        return true;
    }

    /**
     *  Remueve todos los elementos del arbol.
     */
    public void clear( )
    {
        raiz = null;
        cantidad = 0;
    }
    
    /**
     *  Determina si en el arbol existe un elemento que coincida con x. 
     *  @return true si x esta en el arbol - false si x no esta o si x es null.
     *  @param x el objeto a buscar.
     */
    public boolean contains(T x)
    {
        return (this.search(x) != null); 
    }
    
    /**
     * Retorna true si el arbol esta vacio.
     * @return true si el arbol esta vacio - false en caso contrario.
     */
    public boolean isEmpty()
    {
        return (raiz == null);    
    }
    
    /**
      Borra el nodo del arbol que contiene al objeto x. 
      @param x el objeto a borrar.
      @return true si la eliminacion pudo hacerse, o false en caso contrario.
    */
    public boolean remove(T x)
    {       
       if(x == null) { return false; }
       
       int ca = this.size();
       raiz = eliminar(raiz, x);
       return (this.size() != ca);
    }
    
    /**
     * Busca un objeto en el arbol y retorna la direccion del nodo que lo contiene,
     * o null si no lo encuentra. 
     * @param x el objeto a buscar.
     * @return la direccion del objeto encontrado que coincide con x, o null si x no se encuentra. 
     */
    public T search(T x)
    {       
       if(x == null) { return null; }
       
       NodeTree <T> p = raiz;
       while(p != null)
       {
              T y = p.getInfo();
              if(x.compareTo(y) == 0) { break; }
              if(x.compareTo(y) <  0) { p = p.getIzquierdo(); }
              else { p = p.getDerecho(); }
       }
       return (p != null)? p.getInfo() : null;
    }
    
    /**
     * Retorna la cantidad de elementos del arbol.
     * @return la cantidad de elementos del arbol.
     */
    public int size()
    {
        return cantidad;
    }

    /**
      Redefinicion de toString.
      @return el contenido del arbol, en secuencia de entre orden, como un String.
    */
    @Override
    public String toString()
    {
       StringBuffer cad = new StringBuffer("");
       armarEntreOrden(raiz, cad);
       return cad.toString();       
    }

    /**
      Genera un String con el contenido del arbol en pre orden. 
      @return el contenido del arbol, en secuencia de pre orden, como un String.
    */
    public String toPreOrdenString()
    {
       StringBuffer cad = new StringBuffer("");
       armarPreOrden(raiz, cad);
       return cad.toString();       
    }

    /**
      Genera un String con el contenido del arbol en entre orden. Genera el mismo String que el 
      metodo toString() redefinido en la clase.
      @return el contenido del arbol, en secuencia de entre orden, como un String.
    */
    public String toEntreOrdenString()
    {
       return this.toString();
    }

    /**
      Genera un String con el contenido del arbol en post orden. 
      @return el contenido del arbol, en secuencia de post orden, como un String.
    */
    public String toPostOrdenString()
    {
       StringBuffer cad = new StringBuffer("");
       armarPostOrden(raiz, cad);
       return cad.toString();       
    }

    private void armarPreOrden(NodeTree <T> p, StringBuffer cad)
    {
      if (p != null) 
      {
        cad = cad.append(p.getInfo().toString() + " ");         
        armarPreOrden (p.getIzquierdo(), cad);
        armarPreOrden (p.getDerecho(), cad);
      }
    }

    private void armarEntreOrden (NodeTree <T> p, StringBuffer cad)
    {
      if (p != null) 
      {
        armarEntreOrden (p.getIzquierdo(), cad);
        cad = cad.append(p.getInfo().toString() + " ");         
        armarEntreOrden (p.getDerecho(), cad);
      }
    }

    private void armarPostOrden (NodeTree <T> p, StringBuffer cad)
    {
      if (p != null) 
      {
        armarPostOrden (p.getIzquierdo(), cad);
        armarPostOrden (p.getDerecho(), cad);
        cad = cad.append(p.getInfo().toString() + " ");         
      }
    }

    /*
      Auxiliar del metodo de borrado. Borra un nodo que contenga al objeto x si el mismo 
      tiene un hijo o ninguno.
      @param p nodo que esta siendo procesado.
      @param x Objeto a borrar.
      @return direccion del nodo que quedo en lugar del que venia en "p" al comenzar el proceso.
    */
    private NodeTree <T> eliminar (NodeTree <T> p, T x)
    {
       if (p != null)
       {
         T y = p.getInfo();
         if ( x.compareTo(y) < 0 ) 
         { 
             NodeTree <T> menor = eliminar(p.getIzquierdo(), x);
             p.setIzquierdo(menor);   
         }
         else
         {
              if ( x.compareTo(y) > 0 ) 
              { 
                 NodeTree <T> mayor = eliminar (p.getDerecho(), x);
                 p.setDerecho(mayor); 
              } 
              else
              {  
                 // Objeto encontrado... debe borrarlo.
                 if (p.getIzquierdo() == null) { p = p.getDerecho(); }
                 else
                 {
                    if (p.getDerecho() == null) { p = p.getIzquierdo(); }
                    else 
                    {
                        // Tiene dos hijos... que lo haga otra!!!
                        NodeTree <T> dos = dosHijos(p.getIzquierdo(), p);
                        p.setIzquierdo(dos);
                    }
                 }
                 cantidad--;
              }
         }
       }
       return p;
    }
    
    /*
      Auxiliar del metodo de borrado. Reemplaza al nodo que ven�a en "p" por su mayor descendiente izquierdo "d", 
      y luego borra a "d" de su posicion original
      @param d nodo que esta siendo procesado
      @param p nodo a reemplazar por d
      @return direccion del nodo que quedo en lugar del que venia en "d" al comenzar el proceso.
    */    
    private NodeTree <T> dosHijos (NodeTree <T> d, NodeTree <T> p)
    {
       if (d.getDerecho() != null) 
       { 
           NodeTree <T> der = dosHijos(d.getDerecho(), p);
           d.setDerecho(der); 
       }
       else 
       {
           p.setInfo(d.getInfo());
           d = d.getIzquierdo();
       }
       return d;
    }

    public String firstWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String firstDepth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String firstBetter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String aStar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Component getRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
