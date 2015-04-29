package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestEstatusJPA {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        // ID existing the account on database, this case ID: 1
        Conta conta = manager.find(Conta.class, 1);
        System.out.println(conta.getTitular());

        // Change account
        conta.setTitular("Ildo Zacarias");

        System.out.println(conta.getTitular());

        manager.getTransaction().commit();
        manager.close();
    }
}
