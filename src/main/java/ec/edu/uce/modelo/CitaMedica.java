package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita_medica")
	@SequenceGenerator(name = "seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@Column(name = "cime_id")
	private Integer id;

	@Column(name = "cime_numero_cita")
	private String numeroCita;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;

	@Column(name = "cime_valor_cita")
	private BigDecimal valorCita;

	@Column(name = "cime_lugar_cita")
	private String lugarCita;

	@Column(name = "cime_diagnostico")
	private String diagnostico;

	@Column(name = "cime_receta")
	private String receta;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "cime_fecha_control")
	private LocalDateTime fechaControl;

	@ManyToOne
	@JoinColumn(name = "doct_id")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "paci_id")
	private Paciente paciente;

	// metodos set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(String numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaControl;
	}

	public void setFechaProximaCita(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numeroCita=" + numeroCita + ", fechaCita=" + fechaCita + ", valorCita="
				+ valorCita + ", lugarCita=" + lugarCita + ", diagnostico=" + diagnostico + ", receta=" + receta
				+ ", fechaProximaCita=" + fechaControl + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}

}
