package br.com.caelum.financas.jpa;

import javax.persistence.EntityManager;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

    public static void main(String[] args) {
    	double inicio = System.currentTimeMillis();
        Conta conta = new Conta();
        conta.setTitular("Nico Steppat");
        conta.setBanco("Itau");
        conta.setAgencia("3456");
        conta.setNumero("918273-4");
                    
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
        em.close();
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");           
    }
}