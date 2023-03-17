package com.prodemy.tugasCRUD.java.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dosen;

import java.io.IOException;
import java.util.List;

import dao.DosenDao;

/**
 * Servlet implementation class DosenController
 */
@WebServlet("/")
public class GetDosenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDosenController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String crud = request.getServletPath();
//		String crud2 = request.getQueryString();
		try {
			switch (crud) {
			case "/formTambahData":
				formTambahData(request, response);
				break;
			case "/tambahData":
				tambahData(request, response);
				break;
			case "/formUbahData":
				formUbahData(request, response);
				break;
			case "/ubahData":
				ubahData(request, response);
				break;
			case "/hapusData":
				hapusData(request, response);
				break;
			default:
				listData(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void listData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DosenDao dao = new DosenDao();
		List<Dosen> dosen = dao.getAllDosen();
		request.setAttribute("dosen", dosen);

		RequestDispatcher rd = request.getRequestDispatcher("tampil.jsp");
//		System.out.println("list data");
		rd.forward(request, response);
	}

	private void formTambahData(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("tambah.jsp");
		rd.forward(request, response);
//		response.sendRedirect("tambah.jsp");
	}

	protected void tambahData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kode_dosen = request.getParameter("kode_dosen");
		String nama_dosen = request.getParameter("nama_dosen");
		Dosen dosen = new Dosen(kode_dosen, nama_dosen);
		DosenDao dao = new DosenDao();
		dao.addDosen(dosen);
//		listData(request, response);
		response.sendRedirect("/CrudDosen/");
	}

	private void formUbahData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("ubah.jsp");
		String kode_dosen = request.getParameter("kode_dosen");
		DosenDao dao = new DosenDao();
		Dosen dosen = dao.getDosen(kode_dosen);
		request.setAttribute("dosen", dosen);
		rd.forward(request, response);
	}

	private void ubahData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kode_dosen = request.getParameter("kode_dosen");
		String nama_dosen = request.getParameter("nama_dosen");
//		Dosen dosen = new Dosen(kode_dosen, nama_dosen);
		DosenDao dao = new DosenDao();
		dao.editDosen(kode_dosen, nama_dosen);
		response.sendRedirect("/CrudDosen/");
//		listData(request, response);

	}

	private void hapusData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kode_dosen = request.getParameter("kode_dosen");
		String nama_dosen = request.getParameter("nama_dosen");
		Dosen dosen = new Dosen(kode_dosen, nama_dosen);
		DosenDao dao = new DosenDao();
		dao.deleteDosen(dosen);
		response.sendRedirect("/CrudDosen/");
//		listData(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
