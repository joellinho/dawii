package persistencia.service;

import java.util.List;

import persistencia.entidades.Empresa;

public interface EmpresaService {

	void insertar(Empresa empresa);
	void actualizar(Empresa empresa);
	void eliminar(Empresa empresa);
	List<Empresa> listarEmpresa();	
	Empresa obtenerPorId(int id);
	
}
