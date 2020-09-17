package br.com.igrejanazarenojanga.projectNazaJanga;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import connectionjdbc.SingleConnection;
import dao.MemberNazaJangaDAO;
import model.BeanMemberPhone;
import model.MemberNazaJanga;
import model.PhoneMember;

public class TestDataBaseJdbc {

	@Test
	// Método de teste para inserir no banco de dados
	public void initBanco() {

		MemberNazaJangaDAO memberNazaJangaDAO = new MemberNazaJangaDAO();
		MemberNazaJanga memberNazaJanga = new MemberNazaJanga();

		memberNazaJanga.setNameMember("Gabriel Pereira");
		memberNazaJanga.setEmail("gabriel@gmail.com");
		memberNazaJanga.setDateOfBirth("01/07/1992");
		memberNazaJanga.setFatherName("José Américo Pereira");
		memberNazaJanga.setMotherName("Sandra Maria Ferreira Pereira");

		memberNazaJangaDAO.saveMember(memberNazaJanga);

	}

	@Test
	// Método de teste para consultar por lista no banco de dados apenas da entidade membros
	public void initConsultMember() {
		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
		try {
			List<MemberNazaJanga> list = dao.listMember();

			for (MemberNazaJanga memberNazaJanga : list) {

				System.out.println(memberNazaJanga);
				System.out.println("--------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	// Método de teste para consultar por Objeto no banco de dados
	public void initFind() {

		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();

		try {
			MemberNazaJanga memberNazaJanga = dao.findMember(14L);
			System.out.println(memberNazaJanga);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initUpdate() {

		try {
			MemberNazaJangaDAO dao = new MemberNazaJangaDAO();

			MemberNazaJanga objectData = dao.findMember(4L);

			objectData.setNameMember("Antônio Pereira");
			objectData.setEmail("antoniopereira@gmail.com");
			objectData.setDateOfBirth("07/01/1990");
			objectData.setFatherName("Antonio Pai da costa");
			objectData.setMotherName("Mae de Antonio da costa");

			dao.updateMember(objectData);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	// Método teste de deleção
	public void initDelete() {
		try {
			MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
			dao.deleteMember(9L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Método teste Salvar número do membro.
	@Test
	public void initSaveNumberMember() {

		PhoneMember phoneMember = new PhoneMember();

		phoneMember.setNumberPhone("(81)996075634");
		phoneMember.setTypePhone("Celular");
		phoneMember.setUserpeople(4L);

		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
		dao.saveNumberMember(phoneMember);

	}
	//Método de teste para recuperar informações de um membro.
	@Test
	public void initFindAllTables() {

		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
		List<BeanMemberPhone> beanMemberPhones = dao.listMemberPhone(4L);

		for (BeanMemberPhone beanMemberPhone : beanMemberPhones) {

			System.out.println(beanMemberPhone);
			System.out.println("--------------------------------------------------------------------------");

		}

	}
	//Método de teste para recuperar todos os membros com números salvos.
	@Test
	public void initFindAllMemberPhone() {

		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
		List<BeanMemberPhone> beanMemberPhones = dao.listAllMemberPhone();

		for (BeanMemberPhone beanMemberPhone : beanMemberPhones) {
			System.out.println(beanMemberPhone);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------");
		}

	}
	//Método de teste para realizar deleção de membro com números cadastrados.
	@Test
	public void initDeletePhoneAndMember() {
		MemberNazaJangaDAO dao = new MemberNazaJangaDAO();
		dao.deletePhoneAndMember(1L);
		
	}

}
