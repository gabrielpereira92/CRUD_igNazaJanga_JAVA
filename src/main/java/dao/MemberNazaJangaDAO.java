package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import connectionjdbc.SingleConnection;
import model.BeanMemberPhone;
import model.MemberNazaJanga;
import model.PhoneMember;

public class MemberNazaJangaDAO {

	private Connection connection;

	public MemberNazaJangaDAO() {

		connection = SingleConnection.getConnection();
	}

	// método para salvar(inserir no banco) a entidade membroNazajanga
	public void saveMember(MemberNazaJanga memberNazaJanga) {
		try {
			
			
			String sql = "insert into membernazajanga(namemember, email, dateofbirth, fathername, mothername) values (?,?,?,?,?)";
			PreparedStatement inStatement = connection.prepareStatement(sql);
			inStatement.setString(1, memberNazaJanga.getNameMember());
			inStatement.setString(2, memberNazaJanga.getEmail());
			inStatement.setString(3, memberNazaJanga.getDateOfBirth());
			inStatement.setString(4,  memberNazaJanga.getFatherName());
			inStatement.setString(5, memberNazaJanga.getMotherName());
			
			inStatement.execute(); // executa as instruções
			connection.commit(); // Salva no banco

		} catch (Exception e) {
			try {
				// Retorna as configurações antigas em caso de falha e não salva no banco.
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	// Método para inserir na tabela telefone a entidade PhoneMember.

	public void saveNumberMember(PhoneMember phoneMember) {

		try {
			String sql = "INSERT INTO phonemember(numberphone,typephone,userpeople) VALUES (?,?,?)";
			PreparedStatement inStatement = connection.prepareStatement(sql);
			inStatement.setString(1, phoneMember.getNumberPhone());
			inStatement.setString(2, phoneMember.getTypePhone());
			inStatement.setLong(3, phoneMember.getUserpeople());

			inStatement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}

	}

	// Método de consulta que retorna uma Lista do Objeto MemberNazaJangaDAO
	public List<MemberNazaJanga> listMember() throws Exception {
		// Lista de Objetos instanciadas.
		List<MemberNazaJanga> list = new ArrayList<MemberNazaJanga>();
		// Objeto que vem da conexão

		String sql = "select * From membernazajanga";
		// Prepara o SQL
		PreparedStatement inStatement = connection.prepareStatement(sql);
		// Objeto de Resultado
		ResultSet result = inStatement.executeQuery();

		while (result.next()) {
			// instancia o Objeto
			MemberNazaJanga memberNazaJanga = new MemberNazaJanga();
			memberNazaJanga.setId(result.getLong("id"));
			memberNazaJanga.setNameMember(result.getString("namemember"));
			memberNazaJanga.setEmail(result.getString("email"));
			memberNazaJanga.setDateOfBirth(result.getString("dateofbirth"));
			memberNazaJanga.setFatherName(result.getString("fathername"));
			memberNazaJanga.setMotherName(result.getString("mothername"));

			list.add(memberNazaJanga);
		}
		return list;
	}

	// Método de consulta que retorna Apenas Objeto MemberNazaJangaDAO
	public MemberNazaJanga findMember(Long id) throws Exception {
		// Lista de Objetos instanciadas.
		MemberNazaJanga find = new MemberNazaJanga();
		// Objeto que vem da conexão

		String sql = "select * From membernazajanga where id = " + id;
		// Prepara o SQL
		PreparedStatement inStatement = connection.prepareStatement(sql);
		// Objeto de Resultado
		ResultSet result = inStatement.executeQuery();

		while (result.next()) {
			find.setId(result.getLong("id"));
			find.setNameMember(result.getString("namemember"));
			find.setEmail(result.getString("email"));
			find.setDateOfBirth(result.getString("dateofbirth"));
			find.setFatherName(result.getString("fathername"));
			find.setMotherName(result.getString("mothername"));

		}
		return find;
	}

	// Método de consulta que retorna os dados das duas tabelas membros e telefones, passando por parâmetro o ID do membro.
	public List<BeanMemberPhone> listMemberPhone(Long idMember) {
		List<BeanMemberPhone> beanMemberPhone = new ArrayList<BeanMemberPhone>();

		String sql = " select namemember, email, typephone, numberphone, dateofbirth, fathername, mothername from phonemember as phone ";
		sql += " inner join membernazajanga as memberch ";
		sql += " on phone.userpeople = memberch.id ";
		sql += " where memberch.id = " + idMember;

		try {
			PreparedStatement inStatement = connection.prepareStatement(sql);
			ResultSet result = inStatement.executeQuery();

			while (result.next()) {
				BeanMemberPhone memberPhone = new BeanMemberPhone();
				memberPhone.setEmail(result.getString("email"));
				memberPhone.setNameMember(result.getString("namemember"));
				memberPhone.setNumberPhone(result.getString("numberphone"));
				memberPhone.setTypePhone(result.getString("typephone"));
				memberPhone.setDateOfBirth(result.getString("dateofbirth"));
				memberPhone.setFatherName(result.getString("fathername"));
				memberPhone.setMotherName(result.getString("mothername"));

				beanMemberPhone.add(memberPhone);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beanMemberPhone;

	}
	// método que lista todos os membros com todos os seus telefones.
	public List<BeanMemberPhone> listAllMemberPhone(){

		List<BeanMemberPhone> beanMemberPhone = new ArrayList<BeanMemberPhone>();
		
		String sql = "select * from phonemember as phone " ;
				sql += " inner join membernazajanga as memberch ";  
				sql += " on phone.userpeople = memberch.id ";
				
		try {
			PreparedStatement inStatement = connection.prepareStatement(sql);
			ResultSet result = inStatement.executeQuery();
			
			while(result.next()) {
				BeanMemberPhone memberPhone = new BeanMemberPhone();
				memberPhone.setEmail(result.getString("email"));
				memberPhone.setNameMember(result.getString("namemember"));
				memberPhone.setNumberPhone(result.getString("numberphone"));
				memberPhone.setTypePhone(result.getString("typephone"));
				memberPhone.setDateOfBirth(result.getString("dateofbirth"));
				memberPhone.setFatherName(result.getString("fathername"));
				memberPhone.setMotherName(result.getString("mothername"));
				
				beanMemberPhone.add(memberPhone);
							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return beanMemberPhone;
	}
	
	// Método atualizar dados na tabela
	public void updateMember(MemberNazaJanga memberNazaJanga) {

		try {
			String sql = "update membernazajanga set namemember = ?, email = ?, dateofbirth = ?, fathername = ?, mothername = ? where id =  " + memberNazaJanga.getId();

			PreparedStatement inStatement = connection.prepareStatement(sql);
			inStatement.setString(1, memberNazaJanga.getNameMember());
			inStatement.setString(2, memberNazaJanga.getEmail());
			inStatement.setString(3, memberNazaJanga.getDateOfBirth());
			inStatement.setString(4,  memberNazaJanga.getFatherName());
			inStatement.setString(5, memberNazaJanga.getMotherName());

			inStatement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// Método para deleção de membros por ID
	public void deleteMember(Long id) {

		try {

			String sql = "delete from membernazajanga where  id = " + id;
			PreparedStatement inStatement = connection.prepareStatement(sql);
			inStatement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	// Método que deleta os telefones e membros passando por parâmetro o ID.
	public void deletePhoneAndMember(Long id) {
		
		String sqlPhone = "delete from phonemember where userpeople = "+ id;
		String sqlMember = "delete from membronazajanga where id = " + id;
		
		try {
			PreparedStatement insStatement = connection.prepareStatement(sqlPhone);
			insStatement.executeUpdate();
			connection.setAutoCommit(true);
			
			insStatement = connection.prepareStatement(sqlMember);
			insStatement.executeUpdate();
			connection.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}
}
