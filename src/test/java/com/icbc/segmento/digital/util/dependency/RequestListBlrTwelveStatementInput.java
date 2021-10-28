package com.icbc.segmento.digital.util.dependency;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
/**
 * Request Entidad para consultar las liquidaciones del usuario
 **/
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "req")

// @ApiModel(description = "Request Entidad para consultar las liquidaciones del usuario")
public class RequestListBlrTwelveStatementInput extends Request implements Serializable {
	private static final long serialVersionUID = 3L;
  private ListBlrTwelveStatementInput data = null;

  /**
   **/
  public RequestListBlrTwelveStatementInput data(ListBlrTwelveStatementInput data) {
    this.data = data;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(value = "")
  @JsonProperty("data")
  public ListBlrTwelveStatementInput getData() {
    return data;
  }

  public void setData(ListBlrTwelveStatementInput data) {
    this.data = data;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestListBlrTwelveStatementInput requestListBlrTwelveStatementInput = (RequestListBlrTwelveStatementInput) o;
    return Objects.equals(data, requestListBlrTwelveStatementInput.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\"class\": ").append("\"RequestListBlrTwelveStatementInput\"");
    sb.append(", ");
    sb.append(super.toString());
    if(data != null) {
      sb.append(", ");
      sb.append("\"data\": ");
      sb.append(data);
    }
    sb.append("}");
    return sb.toString();
  }

  public int toStringSensitiveData(StringBuilder sb) {
    int varCount = 0;
    sb.append("{\"class\": ").append("\"RequestListBlrTwelveStatementInput\"");
          varCount += data.toStringSensitiveData(sb);
    sb.append("}");
    return varCount;
  }
}
