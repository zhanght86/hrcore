/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhrcore.msg.pay;

import org.jhrcore.ui.language.WebHrMessage;

/**
 *
 * @author mxliteboss
 */
public enum PayAnalyseMsg {

    ttl001("�ֶ�����"),
    ttl002("ͳ������: "),
    ttl003("������������"),
    ttl004("��ʾ����"),
    ttl005("����������"),
    ttl006("�༭������"),
    ttl007("��������"),
    ttl008("�����"),
    ttl009("����"),
    ttl010("���Ŵ�͸"),
    ttl011("�Զ�����Ŀ"),
    ttl012("��ϸ��Ϣ"),
    ttl013("���˴�͸"),
    ttl014("��ѡ�񿼺�ָ��(��׼)"),
    ttl015("�������ɽ��......"),
    ttl016("��"),
    ttl017("�� �� "),
    ttl018("��"),
    ttl019("�춯�Աȱ� "),
    ttl020("����EXCEL"),
    ttl021("����Ԥ��"),
    ttl022("�ر�"),
    ttl023("�½�����"),
    ttl024("���淽��"),
    ttl025("������Ա"),
    ttl026("��������"),
    ttl027("�� �� "),
    ttl028("����"),
    ttl029("Ա��"),
    ttl030("�ϼ�"),
    ttl031("�ֲ�"),
    ttl032("�� "),
    ttl033("ͳ�Ʒ�ʽ:"),
    ttl034("���һ�������ù�������"),
    ttl035("���Ĳ�������ͳ�Ʋο���Ŀ"),
    ttl036("������������ͳ����Ŀ"),
    ttl037("��һ��������ͳ�Ʒ�������"),
    msg001("��ȷ��Ҫɾ��������"),
    msg002("���������������༭"),
    msg003("�����޶Ա��ִ������Ա�"),
    msg004("HR��ؽ��飺"),
    msg005("1, ����ѡȡ����ĳ��ȹ��ർ�µ����ƴ�ӹ�����������ٱ��볤��."),
    msg006("2, ���ڷֶκ����ֶι��ർ�µ����ƴ�ӹ�����������ٷֶθ���."),
    msg007("3, ���ڷֶκ��������µ����ִ�д��󣬽�����ֶθ���."),
    msg008("4, �����Զ�����Ŀ�����µ����ִ�д��󣬽������Զ�����Ŀ."),
    msg009("��������Ŀ����!"),
    msg010("�������ʽ����Ϊ��!"),
    msg011("     ��ǰ��¼����"),
    msg012("��ʼ�·ݲ��ɳ��ڽ����·�"),
    msg013("�ı�ͳ�Ʒ�ʽĬ��ֵ������գ��Ƿ�ı䣿"),
    msg014("û�п�ͳ������"),
    msg015("��ѡ��ͳ�����"),
    msg016("�ڶ���������ͳ����ز���"),
    msg017("��ѡ�񷽰�!"),
    msg018("��ǰ����Ϊ�գ��޷�����!"),
    msg019("�������Ʋ���Ϊ��!"),
    msg020("���淽���ɹ�!"),
    msg021("����ѡ��һ������!"),
    msg022("����ѡ��һ�����Ż���һ��Ա��!"),
    msg023("��ѡ��ͳ���ֶ�!"),
    msg024("��ѡ��ͳ����"),
    msg025("��ѡ�����ͳ������"),
    msg026("��ѡ������ͳ������"),
    msg027("���Զ�����Ŀ�ſɱ༭"),
    msg028("�������Ѿ�����");
    private String value;

    private PayAnalyseMsg() {
    }

    private PayAnalyseMsg(String value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return WebHrMessage.getMsgString(PayAnalyseMsg.class, this.name(), this.value);
    }
}