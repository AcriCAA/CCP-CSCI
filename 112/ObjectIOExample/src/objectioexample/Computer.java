/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectioexample;

/**
 *
 * @author c310
 */
import java.io.Serializable;
class Computer implements Serializable
{
private String Manufacture;
private String Model;
private int HarddiskSize;

public Computer (String s1, String s2, int size) 
{
Manufacture = s1;
Model = s2;
HarddiskSize = size;
}
public String getFullName() 
{
  return Manufacture + " " + Model;
}
public String getModel() 
{
  return Model;
}

}
