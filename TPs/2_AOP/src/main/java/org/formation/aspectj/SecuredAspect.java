package org.formation.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.formation.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecuredAspect {
    private static final Logger logger = LoggerFactory.getLogger(SecuredAspect.class);

    @Autowired
    Authentication authentication;
    

    @Around("@annotation(secured)")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        if (secured.isLocked() && !authentication.isAuthenticated() ) {
            logger.info("{} is locked",pjp.getSignature().toLongString());
            return null;
        } else {
            return pjp.proceed();
        }
    }
}
