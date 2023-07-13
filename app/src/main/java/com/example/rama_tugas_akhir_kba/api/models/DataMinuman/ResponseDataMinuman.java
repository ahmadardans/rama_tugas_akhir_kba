package com.example.rama_tugas_akhir_kba.api.models.DataMinuman;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDataMinuman{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataMinuman")
	private List<DataMinumanItem> dataMinuman;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataMinuman(List<DataMinumanItem> dataMinuman){
		this.dataMinuman = dataMinuman;
	}

	public List<DataMinumanItem> getDataMinuman(){
		return dataMinuman;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDataMinuman{" + 
			"pesan = '" + pesan + '\'' + 
			",dataMinuman = '" + dataMinuman + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}