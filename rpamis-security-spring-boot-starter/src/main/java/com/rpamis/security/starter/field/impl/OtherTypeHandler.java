package com.rpamis.security.starter.field.impl;

import com.rpamis.security.starter.field.ProcessContext;
import com.rpamis.security.starter.field.TypeHandler;
import com.rpamis.security.starter.utils.MaskAnnotationResolver;

import java.util.Deque;
import java.util.Set;

/**
 * 处理自定义返回体等非java提供类型
 *
 * @author benym
 * @date 2023/9/6 17:33
 */
public class OtherTypeHandler implements TypeHandler {

    @Override
    public boolean handle(ProcessContext processContext) {
        Class<?> fieldValueClass = processContext.getFieldValueClass();
        Object fieldValue = processContext.getFieldValue();
        Set<Integer> referenceSet = processContext.getReferenceSet();
        Deque<Object> analyzeDeque = processContext.getAnalyzeDeque();
        if (MaskAnnotationResolver.isNotBaseType(fieldValueClass, fieldValue, referenceSet)) {
            analyzeDeque.offer(fieldValue);
            return true;
        }
        return false;
    }
}
