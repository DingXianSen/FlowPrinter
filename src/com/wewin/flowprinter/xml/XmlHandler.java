package com.wewin.flowprinter.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

	private String tagValue;
	String label;

	private String user_inputNum, guanglu_Name, user_addr;

	public String getUser_inputNum() {
		return user_inputNum;
	}

	public String getGuanglu_Name() {
		return guanglu_Name;
	}

	public String getUser_addr() {
		return user_addr;
	}

	/**
	 * �ڽ��͵�һ����ʼԪ��ʱ����ô˷���.���ǵ�Ԫ�����ظ�ʱ�����Լ�д�㷨������
	 * 
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		label = qName;
		if (attributes != null && attributes.getLength() != 0) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.print(attributes.getQName(i) + "=");
				System.out.print(attributes.getValue(i) + " ");
			}
		}
	}

	/**
	 * ������������ǩʱ���ô˷���
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("user_inputNum".equals(qName)) {
			user_inputNum = tagValue;
			return;
		}
		if ("guanglu_Name".equals(qName)) {
			guanglu_Name = tagValue;
			return;
		}
		if ("user_addr".equals(qName)) {
			user_addr = tagValue;
			return;
		}
	}

	/**
	 * ���е�XML�ļ��е��ַ���ŵ�tagValue��
	 */
	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {
		tagValue = new String(ch, start, length).trim();
	}

}
