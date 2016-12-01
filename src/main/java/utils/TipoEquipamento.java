package utils;

public enum TipoEquipamento {
	DATASHOW_VGA,
	DATASHOW_HDMI,
	CABO_HDMI,
	CABO_VGA,
	EXTENSAO,
	MICROFONE;
	
	 public String getDescricao() {
		   switch(this) {
		   	case DATASHOW_VGA:   return "DataShow VGA";
	   		case DATASHOW_HDMI: return "DataShow HDMI";
	   		case CABO_HDMI:     return "Cabo HDMI";
	   		case CABO_VGA:     return "Cabo VGA";
	   		case EXTENSAO:      return "Extensão";
	   		case MICROFONE:     return "Microfone";
		   	default :       return "";
		   }
	 }
	
}
