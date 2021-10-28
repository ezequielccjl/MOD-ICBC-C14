package com.icbc.segmento.digital.util.dependency;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Date;

import java.io.Serializable;
/**
 * Entidad para consultar las liquidaciones del usuario
 **/
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "data")

// @ApiModel(description = "Entidad para consultar las liquidaciones del usuario")
public class ListBlrTwelveStatementInput  implements Serializable {
	private static final long serialVersionUID = 1L;
  private String cardBrandIndicatorCode = null;

  private String cardProductNumber = null;

  private Date fromDate = null;

  private Date toDate = null;

  private String maxResultsNumber = null;

  /**
   **/
  public ListBlrTwelveStatementInput cardBrandIndicatorCode(String cardBrandIndicatorCode) {
    this.cardBrandIndicatorCode = cardBrandIndicatorCode;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(example = "master", value = "")
  @JsonProperty("cardBrandIndicatorCode")
  public String getCardBrandIndicatorCode() {
    return cardBrandIndicatorCode;
  }

  public void setCardBrandIndicatorCode(String cardBrandIndicatorCode) {
    this.cardBrandIndicatorCode = cardBrandIndicatorCode;
  }


  /**
   **/
  public ListBlrTwelveStatementInput cardProductNumber(String cardProductNumber) {
    this.cardProductNumber = cardProductNumber;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(example = "30667831", value = "")
  @JsonProperty("cardProductNumber")
  public String getCardProductNumber() {
    return cardProductNumber;
  }

  public void setCardProductNumber(String cardProductNumber) {
    this.cardProductNumber = cardProductNumber;
  }


  /**
   **/
  public ListBlrTwelveStatementInput fromDate(Date fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(value = "")
  @JsonProperty("fromDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }


  /**
   **/
  public ListBlrTwelveStatementInput toDate(Date toDate) {
    this.toDate = toDate;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(value = "")
  @JsonProperty("toDate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }


  /**
   **/
  public ListBlrTwelveStatementInput maxResultsNumber(String maxResultsNumber) {
    this.maxResultsNumber = maxResultsNumber;
    return this;
  }

  

  
  
  
  // @ApiModelProperty(example = "20", value = "")
  @JsonProperty("maxResultsNumber")
  public String getMaxResultsNumber() {
    return maxResultsNumber;
  }

  public void setMaxResultsNumber(String maxResultsNumber) {
    this.maxResultsNumber = maxResultsNumber;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListBlrTwelveStatementInput listBlrTwelveStatementInput = (ListBlrTwelveStatementInput) o;
    return Objects.equals(cardBrandIndicatorCode, listBlrTwelveStatementInput.cardBrandIndicatorCode) &&
        Objects.equals(cardProductNumber, listBlrTwelveStatementInput.cardProductNumber) &&
        Objects.equals(fromDate, listBlrTwelveStatementInput.fromDate) &&
        Objects.equals(toDate, listBlrTwelveStatementInput.toDate) &&
        Objects.equals(maxResultsNumber, listBlrTwelveStatementInput.maxResultsNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardBrandIndicatorCode, cardProductNumber, fromDate, toDate, maxResultsNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\"class\": ").append("\"ListBlrTwelveStatementInput\"");

    if(cardBrandIndicatorCode != null) {
   		sb.append(", ");
    	sb.append("\"cardBrandIndicatorCode\": ");
        sb.append("\"");
        sb.append(cardBrandIndicatorCode);
        sb.append("\"");
    }
            if(cardProductNumber != null) {
   		sb.append(", ");
    	sb.append("\"cardProductNumber\": ");
        sb.append("\"");
        sb.append(cardProductNumber);
        sb.append("\"");
    }
            if(fromDate != null) {
   		sb.append(", ");
    	sb.append("\"fromDate\": ");
        sb.append(fromDate);
    }
            if(toDate != null) {
   		sb.append(", ");
    	sb.append("\"toDate\": ");
        sb.append(toDate);
    }
            if(maxResultsNumber != null) {
   		sb.append(", ");
    	sb.append("\"maxResultsNumber\": ");
        sb.append("\"");
        sb.append(maxResultsNumber);
        sb.append("\"");
    }
        sb.append("}");
    return sb.toString();
  }

  public int toStringSensitiveData(StringBuilder sb) {
    int varCount = 0;
    sb.append("{\"class\": ").append("\"ListBlrTwelveStatementInput\"");
                    sb.append("}");
    return varCount;
  }
}
