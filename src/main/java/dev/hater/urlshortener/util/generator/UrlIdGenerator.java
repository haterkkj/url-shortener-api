package dev.hater.urlshortener.util.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.security.SecureRandom;

public class UrlIdGenerator implements IdentifierGenerator {

    private final SecureRandom random = new SecureRandom();

    public UrlIdGenerator(CompactBase64Id compactBase64Id, Member idMember, CustomIdGeneratorCreationContext context) {
    }

    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        long number = Math.abs(random.nextLong() >>> 1);
        String id = Base64UrlSafe.encode(number);

        int digitsQuantity = 6;
        if (id.length() < digitsQuantity) {
            id = String.format("%6s", id).replace(' ', '0');
        } else if (id.length() > digitsQuantity) {
            id = id.substring(0, digitsQuantity);
        }

        return id;
    }

}
