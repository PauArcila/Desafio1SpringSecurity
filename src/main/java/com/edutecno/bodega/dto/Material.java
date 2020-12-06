package com.edutecno.bodega.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Material {
	
	private String precio;
	private String nombreMaterial;
	private Bodega bodega; //string 
	
}
