package uam.admision.sendmail.Model;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class DatosEntrada {
    @Override
    public String toString() {
        return "DatosEntrada{" +
                "plantel_='" + plantel_ + '\'' +
                ", plantel='" + plantel + '\'' +
                ", folio_exa='" + folio_exa + '\'' +
                ", aspirante_no='" + aspirante_no + '\'' +
                ", ape_p_asp_xx='" + ape_p_asp_xx + '\'' +
                ", ape_m_asp_xx='" + ape_m_asp_xx + '\'' +
                ", p_sexo='" + p_sexo + '\'' +
                ", plantel_largo='" + plantel_largo + '\'' +
                ", correo1='" + correo1 + '\'' +
                ", correo2='" + correo2 + '\'' +
                ", unidad_xx='" + unidad_xx + '\'' +
                ", celular_1='" + celular_1 + '\'' +
                ", celular_2='" + celular_2 + '\'' +
                '}';
    }

    @CsvBindByName
    private String plantel_;
    @CsvBindByName
    private String plantel;
    @CsvBindByName
    private String folio_exa;
    @CsvBindByName
    private String aspirante_no;
    @CsvBindByName
    private String ape_p_asp_xx;
    @CsvBindByName
    private String ape_m_asp_xx;
    @CsvBindByName
    private String p_sexo;
    @CsvBindByName
    private String plantel_largo;
    @CsvBindByName
    private String correo1;
    @CsvBindByName
    private String correo2;
    @CsvBindByName
    private String unidad_xx;
    @CsvBindByName
    private String celular_1;
    @CsvBindByName
    private String celular_2;

    public String getPlantel_() {
        return plantel_;
    }

    public void setPlantel_(String plantel_) {
        this.plantel_ = plantel_;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public String getFolio_exa() {
        return folio_exa;
    }

    public void setFolio_exa(String folio_exa) {
        this.folio_exa = folio_exa;
    }

    public String getAspirante_no() {
        return aspirante_no;
    }

    public void setAspirante_no(String aspirante_no) {
        this.aspirante_no = aspirante_no;
    }

    public String getApe_p_asp_xx() {
        return ape_p_asp_xx;
    }

    public void setApe_p_asp_xx(String ape_p_asp_xx) {
        this.ape_p_asp_xx = ape_p_asp_xx;
    }

    public String getApe_m_asp_xx() {
        return ape_m_asp_xx;
    }

    public void setApe_m_asp_xx(String ape_m_asp_xx) {
        this.ape_m_asp_xx = ape_m_asp_xx;
    }

    public String getP_sexo() {
        return p_sexo;
    }

    public void setP_sexo(String p_sexo) {
        this.p_sexo = p_sexo;
    }

    public String getPlantel_largo() {
        return plantel_largo;
    }

    public void setPlantel_largo(String plantel_largo) {
        this.plantel_largo = plantel_largo;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getUnidad_xx() {
        return unidad_xx;
    }

    public void setUnidad_xx(String unidad_xx) {
        this.unidad_xx = unidad_xx;
    }

    public String getCelular_1() {
        return celular_1;
    }

    public void setCelular_1(String celular_1) {
        this.celular_1 = celular_1;
    }

    public String getCelular_2() {
        return celular_2;
    }

    public void setCelular_2(String celular_2) {
        this.celular_2 = celular_2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosEntrada that = (DatosEntrada) o;
        return Objects.equals(getPlantel_(), that.getPlantel_()) &&
                Objects.equals(getPlantel(), that.getPlantel()) &&
                Objects.equals(getFolio_exa(), that.getFolio_exa()) &&
                Objects.equals(getAspirante_no(), that.getAspirante_no()) &&
                Objects.equals(getApe_p_asp_xx(), that.getApe_p_asp_xx()) &&
                Objects.equals(getApe_m_asp_xx(), that.getApe_m_asp_xx()) &&
                Objects.equals(getP_sexo(), that.getP_sexo()) &&
                Objects.equals(getPlantel_largo(), that.getPlantel_largo()) &&
                Objects.equals(getCorreo1(), that.getCorreo1()) &&
                Objects.equals(getCorreo2(), that.getCorreo2()) &&
                Objects.equals(getUnidad_xx(), that.getUnidad_xx()) &&
                Objects.equals(getCelular_1(), that.getCelular_1()) &&
                Objects.equals(getCelular_2(), that.getCelular_2());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlantel_(), getPlantel(), getFolio_exa(), getAspirante_no(), getApe_p_asp_xx(), getApe_m_asp_xx(), getP_sexo(), getPlantel_largo(), getCorreo1(), getCorreo2(), getUnidad_xx(), getCelular_1(), getCelular_2());
    }
}
