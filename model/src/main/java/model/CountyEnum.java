package model;

public enum CountyEnum {
	BÁCS_KISKUN("Bács-Kiskun"),
	BARANYA("Baranya"),
	BÉKÉS("Békés"),
	BORSOD_ABAÚJ_ZEMPLÉN("Borsod-Abaúj-Zemplén"),
	CSONGRÁD("Csongrád"),
	FEJÉR("Fejér"),
	GYŐR_MOSON_SOPRON("Győr-MOson-Sopron"),
	HAJDÚ_BIHAR("Hajdú-Bihar"),
	HEVES("Heves"),
	JÁSZ_NAGYKUN_SZOLNOK("Jász-Nagykun-Szolnok"),
	KOMÁROM_ESZTERGOM("Komárom-Esztergom"),
	NÓGRÁD("Nógrád"),
	PEST("Pest"),
	SOMOGY("Somogy"),
	SZABOLCS_SZATMÁR_BEREG("Szaboly-Szatmár-Bereg"),
	TOLNA("Tolna"),
	VAS("Vas"),
	VESZPRÉM("Veszprém"),
	ZALA("Zala");
	
	private String countyName;
	
	private CountyEnum(String countyName) {
		this.countyName = countyName;
	}
	
	public String getCountyName() {
		return countyName;
	}
}
