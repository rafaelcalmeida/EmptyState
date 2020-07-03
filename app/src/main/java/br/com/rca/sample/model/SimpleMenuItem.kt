package br.com.rca.sample.model

/**
 * Created by Rafael C. Almeida on 2020-04-06.
 */
class SimpleMenuItem(var title: String, var subtitle: String, var actionHandler: (() -> Unit)? = null)