package com.intellij.notification.impl.actions;

import com.intellij.icons.AllIcons;
import com.intellij.notification.EventLog;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.vcs.VcsBundle;
import org.jetbrains.annotations.NotNull;

public class MarkAllNotificationsAsReadAction extends DumbAwareAction {
  public MarkAllNotificationsAsReadAction() {
    super(() -> VcsBundle.message("action.MarkAllNotificationsAsReadAction.text"),
          () -> VcsBundle.message("action.MarkAllNotificationsAsReadAction.description"), AllIcons.Actions.Selectall);
  }

  @Override
  public void update(@NotNull AnActionEvent e) {
    e.getPresentation().setEnabled(!EventLog.getLogModel(e.getData(CommonDataKeys.PROJECT)).getNotifications().isEmpty());
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    EventLog.markAllAsRead(e.getData(CommonDataKeys.PROJECT));
  }
}
