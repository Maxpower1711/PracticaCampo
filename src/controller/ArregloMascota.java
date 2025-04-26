package controller;

import java.util.ArrayList;
import model.Mascota;

public class ArregloMascota {
    private ArrayList<Mascota> masco;
    //un constructor sin pamaetros que cree el objeto ArrayList
    public ArregloMascota(){
        masco=new ArrayList<Mascota>();
    }
    //un metodo adicionar que reciba producto y lo adicione al ArrayList
    public void adicionar(Mascota x){
        masco.add(x);
    }
    //un metodo eliminar que reciba un producto y lo elimine del ArrayList
    public void eliminar(Mascota x){
        masco.remove(x);
    }
    //un metodo obtener que reciba una posicion y retorne el producto de esa posicion
    public Mascota obtener(int pos){
        return masco.get(pos);
    }
    //un metodo buscar que reciba un codigo y retorne el producto con ese codigo
    public Mascota buscar(int codigo){
        for (int i = 0; i < masco.size(); i++) {
            if (codigo==masco.get(i).getCodigo()) {
                return masco.get(i);
            }
        }
        return null;
    }
    //un metodo tamaño que retorne la cantidad de productos ingresados al ArrayList
    public int tamaño(){
        return masco.size();
    }
}
