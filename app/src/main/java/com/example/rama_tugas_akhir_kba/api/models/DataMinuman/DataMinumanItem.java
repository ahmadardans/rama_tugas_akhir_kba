package com.example.rama_tugas_akhir_kba.api.models.DataMinuman;

import com.google.gson.annotations.SerializedName;

public class DataMinumanItem{

	@SerializedName("image")
	private String image;

	@SerializedName("rating`")
	private String rating;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga")
	private String harga;

	@SerializedName("id")
	private String id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataMinumanItem{" + 
			"image = '" + image + '\'' + 
			",rating` = '" + rating + '\'' + 
			",nama = '" + nama + '\'' + 
			",harga = '" + harga + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}