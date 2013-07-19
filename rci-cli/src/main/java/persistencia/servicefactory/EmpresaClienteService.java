package persistencia.servicefactory;

import java.util.List;

import persistence.entity.Empresacliente;

public interface EmpresaClienteService {
	
	public void insertarEmpresaCliente(Empresacliente empresacliente);
	public List<Empresacliente> listarEmpresaCliente();
	public Empresacliente buscarEmpresaClientePorRuc(String ruc);

}
