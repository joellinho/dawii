package persistencia.entidades;

import javax.persistence.*;



@Entity
public class EstadoRegistroPedido{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(11)")
	private int id;
	
	@Column(length=20,nullable=false,unique=true)
	private String descripcion;

	//bi-directional many-to-one association to Pedido
	/*@OneToMany(mappedBy="estadoregistropedido")
	private Collection<Pedido> pedidos = new ArrayList<Pedido>();

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}*/

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}