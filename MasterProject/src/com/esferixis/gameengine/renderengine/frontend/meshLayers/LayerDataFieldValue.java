/**
 * Copyright (c) 2017 Ariel Favio Carrizo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'esferixis' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.esferixis.gameengine.renderengine.frontend.meshLayers;

import java.io.Serializable;

import com.esferixis.misc.ElementCallback;
import com.esferixis.misc.Property.Setteable;
import com.esferixis.misc.observer.ObserverManager;

/**
 * @author ariel
 *
 */
public final class LayerDataFieldValue<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1912589298852968361L;
	
	private final LayerDataField<T> field;
	private T value;
	
	/**
	 * @post Crea el perfil del miembro especificado, con el valor especificado
	 */
	public LayerDataFieldValue(LayerDataField<T> field, T value) {
		if ( ( field != null ) && ( value != null ) ) {
			if ( field.getMeshLayersConfig() != null ) {
				this.field = field;
				this.setValue(value);
			}
			else {
				throw new IllegalStateException("Cannot create field value with an unattached field");
			}
		}
		else {
			throw new NullPointerException();
		}
	}
	
	/**
	 * @post Devuelve al miembro que pertenece
	 */
	LayerDataField<T> getField() {
		return this.field;
	}
	
	/**
	 * @post Especifica el valor
	 */
	public void setValue(final T value) {
		this.field.checkValue(value);
		
		this.value = value;
	}
	
	/**
	 * @post Devuelve el valor
	 */
	public T getValue() {
		return this.value;
	}
}
