/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhrcore.msg.emp;

import org.jhrcore.ui.language.WebHrMessage;

/**
 *
 * @author mxliteboss
 */
public enum EmpMngMsg {

    ttl001("����֤�����ظ�����������������֤��Ϣ:"),
    ttl002("Ա��IC�����ֶ�����"),
    ttl003("��Ա��λ����"),
    ttl004("Ա����ŵ���"),
    ttl005("д��IC����Ϣ"),
    ttl006("�����ĵ�����"),
    ttl007("ͬʱ¼����Ÿ���"),
    ttl008("�����������¸���"),
    ttl009("������Ա��Ϣ"),
    ttl010("ͬʱ�鿴���Ÿ���"),
    ttl011("�������ⲿ��"),
    ttl012("��Ա��ɾ��־"),
//    ttl013("���ø�������"),
    ttl014("�䶯�ֶα༭������"),
    ttl015("��Ա�ȶ�"),
//    ttl016("ѡ��ͼƬ����·��"),
//    ttl017("Excel�ļ�"),
//    ttl018("ͼƬ�ļ�"),
//    ttl019("ѡ�����ļ�"),
    ttl020("�����ȶԽ��"),
    ttl023("����Ԥ����"),
    ttl024("��ȡ����"),
    ttl025("����У�鱨��"),
//    ttl026("ѡ����Ƭ"),
    ttl027("ѡ��ͼƬ����·��:"),
    ttl028("�����ĵ�"),
    ttl029("��ѡ��"),
//    ttl030("���뱨�棺"),
    ttl031("��Ƭ������������﷨������ʾ���£�"),
    ttl032("�������ⲿ��ʧ��"),
    ttl033("������Ա����ƥ���ֶ�:"),
    ttl034(" �ɹ������¼�� "),
    ttl035("��ѡ��Ա"),
    ttl036(" �ɹ����¼�¼�� "),
    ttlApp("�����"),
    ttlUnCommit("δ�ύ"),
    ttlProcess("������"),
    msg001("����֤����Ϊ��"),
    msg002("������֤������Ч"),
    msg003("�뵽ϵͳ�����������ö���֤����Ա��Ϣ��Ӧ"),
    msg004("û���ҵ�������"),
    msg005("����ʧ��"),
    msg006("����֤����Ա�������Ƿ���Ҫ�滻?"),
    msg007("�뵽����������Ա��IC����"),
    msg008("�Ҳ���IC����Ӧ��Ա"),
    msg009("ȷ��Ҫд����Ա��Ϣ?"),
    msgSelectA01Pnl("���л�����Ա������Ϣ����"),
    msgSelectAppendixPnl("���л�����������ѡ�񸽱�"),
    msg012("��ѡ�����ⲿ��"),
    msg013("�˿ڲ���Ϊ��"),
    msg014("��ѡ��δ�ύ�ļ�¼"),
    msg015("���Ƚ����ø����µĹ�����"),
    msg016("��ȷ��Ҫ�ύ��ѡ��¼��?"),
    msg017("��ѡ�����ύ�ļ�¼"),
    msg018("��ȷ��Ҫȡ���ύ��ѡ��¼��?"),
    msg022("��ѡ����Ա"),
    msg023("��������Ա������ֶ�"),
    msg024("û��ƥ����Ƭ"),
    msg025("ͼƬ��С����Ϊ����"),
    msg026("û��ƥ���ֶ�"),
    msg027("һ���Ե�����Ƭ����������10000��"),
    msg028("������ͼƬ������С��"),
    msg029("Ҫ�鿴�ϴ�δ�ɹ�����Ƭ��"),
    msg030("�Ƴ��ɹ�"),
    msg031("û��ѡ���κ���Ա"),
    msg032("ƴ�������ɳɹ���"),
    msg033("��ѡ�����ⲿ�ţ�"),
    msg034("��ѡ�񵼳�·��"),
    msg035("�����Ա����"),
    msg036("������Ƭ������������Ϊ��"),
    msg037("û����Ƭ����"),
    msg038("�ɹ�����ͼƬ����:"),
    msg039("��ʼ������Ƭ��"),
    msg040("û���ҵ�������"),
    msg041("����ʧ��"),
    msg042("���ݿ���û�д���Ա��¼"),
    msg043("������Ա"),
    msg044("����֤�����ظ���Ա"),
    msg045("��"),
    msg046("Ů"),
    msg047("���� (GB/T 3304)"),
    msg048("�뵽ϵͳ�����������ö���֤����Ա��Ϣ��Ӧ"),
    msg049("�빴ѡҪ���µ��ֶ���Ϣ��"),
    msg050("ͼƬ��ʽ����ΪJPG��PNG��GIF��BMP��һ��!"),
    msg051("��ѡͼƬ������ָ����С"),
    msg052("����֤�������!"),
    msg053("��ѡ���ţ�"),
    msg054("��ǰ���Ų�����ְ���ŷ�Χ�ڣ�������������ְ��"),
    msg055("��ѡ�����ļ�"),
    msg056("��ѡ��Ĭ����Ա���"),
    msg057("�����ļ��в�����ƥ����"),
//    msg058("��ѡ��Ĳ�����Ч��EXCEL�ļ�"),
    msg059("�����ļ��в�����ƥ���л�ƥ���в����û�Ȩ�޷�Χ��"),
    msg060("�����ļ��в�����������"),
    msg061("���ݱ����޲��Ŵ����ֶΣ��������������δ����Ĭ�ϲ���"),
    msg062("���ݿ���´���"),
    msg063("��Ա�����(a0190)��������(a0101)�����û�Ȩ�޷�Χ��,����������"),
    msg064("�����ļ���ʽ����,�������ע���ֶ���ע��"),
//    msg065("���ݿ⵼�����"),
//    msg066("δ�ύ"),
    msg067("�����ļ�"),
    msg068("������>"),
    msg069("������<"),
    msg070("�½��ļ���"),
    msg071("�����ĵ�"),
    msg072("�����ĵ�"),
    msg073("$/�����ĵ�/"),
    msg074("$/�����ĵ�/"),
    msg075("�����ļ�"),
    msg076("������Ա"),
    msg077("Ա�����"),
    msg078("Ա������ֶ�����"),
    msg079("�˲�������ɾ��ѡ����Ա�����������������Ϣ��ȷ��Ҫ������?"),
    msg080("������Ա��Ϣ"),
    msg081("�ϴ���Ƭ"),
    msg082("ɾ��ԭ����Ƭ"),
    msg083("��ƬԤ����"),
//    msg084("ȫѡ"),
    msg085("����������"),
    msg086("�ָ�ʧ��"),
    msg087("�ָ��ɹ�"),
//    msg088("�������ʧ��"),
    msg089("����ɾ���ɹ�"),
    msg090("ȷ��Ҫɾ��ѡ�����־��"),
    msg091("���в���"),
    msg092("������֤�Ƿ񱣴���Ƭ"),
    msg093(" �ɹ����룺"),
    msg094(" �ɹ����£�"),
    msg095(" ִ�д���"),
    msg096("����"),
    msg097("���ڵ�������"),
    msg098("������Ϣ�������£�"),
    msg099("�ɸ��¼�¼��"),
    msg100("�ɲ����¼��"),
    msg101("�ظ��ļ�¼��"),
    msg102("���ݿ��Ѵ��ڵļ�¼��"),
    msg103("��ƥ��ļ�¼��"),
    msg104("��ĩ��������Ա��¼��"),
    msg105("���ݸ�ʽ����ļ�¼��"),
    msg106("�ɹ����¼�¼��"),
    msg107("�ɹ������¼��"),
    msg108("�ظ��ļ�¼��"),
    msg109("���ݿ��Ѵ��ڵļ�¼��"),
    msg110("��ƥ��ļ�¼��"),
    msg111("��ĩ��������Ա��¼��"),
    msg112("���ݸ�ʽ����ļ�¼��"),
    msg113("ͼƬ��ʽ����ȷ"),
    msg114("�ɹ�����ͼƬ"),
    msg115("��ǰ��Աû����Ƭ"),
    msg116("ȷ��Ҫ�����Ƭ��?"),
    msg117("��ʾ"),
    msg118("����"),
    msg119("ȷ��Ҫɾ�����ĵ�?"),
    msg120("�Ҳ����ļ�"),
//    msg121("����Ϊ"),
    msg122("ȷ��Ҫɾ����Щ��Ա��¼��?"),
    msg123("���ڱ䶯��"),
    msg124("ɾ��"),
    msg125("������"),
    msg126("��Ա״̬��ʶ"),
    msg127("��Щ��Ա�ѽ���ɾ���䶯���ɽ���������ģ���������ɾ��"),
    msg128("�뵽����������Ա��IC����"),
    msg129( "��Ѱ����Ա"),
    msg130("ȷ��Ҫд����Ա��Ϣ��"),
    msg131("���IC��"),
    msg132("�뵽����������Ա��IC����"),
    msg133("���濨�ŵ���Ա��Ϣ��"),
    msg134("δѡ���κ��ֶ�"),
    msg135("��Ա������¼����������"),
    msg136("����"),
    msg137("ÿ�θ��Ʋ���������"),
    msg138("������δ������Ա"),
    msg139("�����ļ���ʽ����,�������ע���ֶ���ע��"),
    msg140("�����ļ��в�����ƥ���л�ƥ���в����û�Ȩ�޷�Χ��"),
    msg141(" �ɲ�ѯ���ļ�¼��"),
    msg142(" ������еļ�¼��"),
    msg143(" �����δ�ҵ���¼��"),
    msg144("��;"),
    msg145("���淽��ʧ��"),
    msg146("�滻�ɹ�");

    private String value;

    private EmpMngMsg() {
    }

    private EmpMngMsg(String value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return WebHrMessage.getMsgString(EmpMngMsg.class, this.name(), this.value);
    }
}